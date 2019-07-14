package ttc2019.live.generator;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.github.javafaker.Faker;

import ttc2019.live.bibtex.Author;
import ttc2019.live.bibtex.BibTeXEntry;
import ttc2019.live.bibtex.BibTeXFile;
import ttc2019.live.bibtex.BibtexFactory;
import ttc2019.live.bibtex.BibtexPackage;

/**
 * Generates random {@link BibTeXFile} models with a certain number of elements,
 * and an optional predefined seed.
 */
public class Generator {

	public static class StopwatchContext implements AutoCloseable {
		private final long startMillis = System.currentTimeMillis();
		private final String context;
		private boolean closed;

		public StopwatchContext(String context) {
			this.context = context;
		}

		@Override
		public void close() {
			if (!closed) {
				closed = true;

				final long elapsedMillis = System.currentTimeMillis() - startMillis;
				final String message = String.format("Done with %s in %s ms", context, Long.toString(elapsedMillis));
				System.out.println(message);
			}
		}
	}

	// Some uninteresting entry types have been omitted
	private static final EClass[] ENTRY_CLASSIFIERS = {
			BibtexPackage.eINSTANCE.getArticle(),
			BibtexPackage.eINSTANCE.getTechReport(),
			//BibtexPackage.eINSTANCE.getUnpublished(),
			BibtexPackage.eINSTANCE.getManual(),
			BibtexPackage.eINSTANCE.getProceedings(),
			BibtexPackage.eINSTANCE.getInProceedings(),
			//BibtexPackage.eINSTANCE.getBooklet(),
			BibtexPackage.eINSTANCE.getBook(),
			BibtexPackage.eINSTANCE.getInCollection(),
			BibtexPackage.eINSTANCE.getInBook(),
			//BibtexPackage.eINSTANCE.getMisc(),
			BibtexPackage.eINSTANCE.getPhDThesis(),
			BibtexPackage.eINSTANCE.getMasterThesis(),
	};

	private static final int MIN_AUTHORS = 1;
	private static final int MAX_AUTHORS = 10;

	private static final int MIN_CHAPTER = 1;
	private static final int MAX_CHAPTER = 30;

	private final Random rnd;
	private final Faker faker;

	public Generator(Random rnd) {
		this.rnd = rnd;
		this.faker = new Faker(rnd);
	}

	public BibTeXFile generate(int nEntries) {
		final BibTeXFile bibFile = BibtexFactory.eINSTANCE.createBibTeXFile();

		for (int iEntry = 0; iEntry < nEntries; iEntry++) {
			final EClass eClass = ENTRY_CLASSIFIERS[rnd.nextInt(ENTRY_CLASSIFIERS.length)];
			bibFile.getEntries().add(generate(iEntry, eClass));
		}

		return bibFile;
	}
	
	private BibTeXEntry generate(int iEntry, EClass eClass) {
		final BibTeXEntry eob = (BibTeXEntry) BibtexFactory.eINSTANCE.create(eClass);

		for (EAttribute eAttr : eClass.getEAllAttributes()) {
			Object value = null;

			switch (eAttr.getName()) {
			case "id": value = generateID(iEntry); break;
			case "title": value = generateTitle(); break;
			case "note": value = generateNote(); break;
			case "school": value = generateSchool(); break;
			case "publisher": value = generatePublisher(); break;
			case "journal": value = generateJournal(); break;
			case "chapter": value = generateChapter(); break;
			case "year": value = generateYear(); break;
			case "booktitle": value = generateBookTitle(); break;
			default:
				System.err.println(String.format(
					"Unknown attribute %s in EClass %s::%s, ignoring",
					eAttr.getName(), eClass.getEPackage().getNsURI(), eClass.getName()
				));
				break;
			}

			if (value != null) {
				eob.eSet(eAttr, value);
			}
		}

		for (EReference eRef : eClass.getEAllReferences()) {
			switch (eRef.getName()) {
			case "authors":
				EList<Author> authors = generateAuthors();
				eob.eSet(eRef, authors);
				break;
			default:
				System.err.println(String.format(
					"Unknown attribute %s in EClass %s::%s, ignoring",
					eRef.getName(), eClass.getEPackage().getNsURI(), eClass.getName()
				));
				break;
			}
		}
		
		return eob;
	}

	private EList<Author> generateAuthors() {
		final int nAuthors = MIN_AUTHORS + rnd.nextInt(MAX_AUTHORS - MIN_AUTHORS + 1);

		final EList<Author> authors = new BasicEList<Author>();
		for (int iAuthor = 0; iAuthor < nAuthors; iAuthor++) {
			Author author = BibtexFactory.eINSTANCE.createAuthor();
			author.setAuthor(faker.book().author());
			authors.add(author);
		}
		return authors;
	}

	private String generateBookTitle() {
		return faker.book().title();
	}

	private int generateYear() {
		final Date pubDate = faker.date().past(365 * 20, TimeUnit.DAYS);
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(pubDate);
		return calendar.get(Calendar.YEAR);
	}

	private int generateChapter() {
		return MIN_CHAPTER + rnd.nextInt(MAX_CHAPTER - MIN_CHAPTER + 1);
	}

	private String generateJournal() {
		return faker.book().title();
	}

	private String generatePublisher() {
		return faker.book().publisher();
	}

	private String generateSchool() {
		return faker.university().name();
	}

	private String generateNote() {
		return faker.lorem().paragraph();
	}

	private String generateTitle() {
		return faker.book().title();
	}

	private String generateID(int iEntry) {
		return "e" + iEntry;
	}

	public static void main(String[] args) {
		if (args.length < 2 || args.length > 3) {
			System.err.println("Usage: java -jar generator.jar destination.bibtex nEntries [seed]");
			System.exit(1);
		}

		final File fDestination = new File(args[0]);
		final int nEntries = Integer.parseInt(args[1]);
		final Random rnd = args.length >= 3 ? new Random(Integer.parseInt(args[2])) : new Random();

		final Generator gen = new Generator(rnd);
		BibTeXFile bibtexFile;
		try (StopwatchContext ctx = new StopwatchContext("Generation")) {
			bibtexFile = gen.generate(nEntries);
		}

		try (StopwatchContext ctx = new StopwatchContext("Save")) {
			saveToFile(bibtexFile, fDestination);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void saveToFile(final BibTeXFile bibtexFile, final File fDestination) throws IOException {
		final ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(BibtexPackage.eNS_URI, BibtexPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		final Resource resource = rs.createResource(URI.createFileURI(fDestination.getCanonicalPath()));
		resource.getContents().add(bibtexFile);
		resource.save(null);
	}
}
