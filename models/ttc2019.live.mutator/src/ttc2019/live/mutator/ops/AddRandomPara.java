package ttc2019.live.mutator.ops;

import java.util.Random;

import org.eclipse.emf.common.util.EList;

import com.github.javafaker.Faker;

import ttc2019.live.changes.ChangesFactory;
import ttc2019.live.changes.CompositionListInsertion;
import ttc2019.live.changes.ModelChangeSet;
import ttc2019.live.docbook.Article;
import ttc2019.live.docbook.Book;
import ttc2019.live.docbook.DocBook;
import ttc2019.live.docbook.DocbookFactory;
import ttc2019.live.docbook.Para;
import ttc2019.live.docbook.Sect1;

public class AddRandomPara extends AbstractMutationOperator {

	private final Faker faker;

	public AddRandomPara(Random rnd) {
		super("APA", rnd);
		this.faker = new Faker(rnd);
	}

	@Override
	public void apply(DocBook toMutate, ModelChangeSet changes) {
		final Book book = toMutate.getBooks().get(0);
		final Article article = book.getArticles().get(0);
		final EList<Sect1> sections1 = article.getSections_1();

		final Sect1 section1 = sections1.get(rnd.nextInt(sections1.size()));
		final EList<Para> paras = section1.getParas();
		final int targetIdx = rnd.nextInt(paras.size() + 1);

		final Para newPara = DocbookFactory.eINSTANCE.createPara();
		newPara.setContent(faker.lorem().paragraph());
		paras.add(targetIdx, newPara);

		CompositionListInsertion change = ChangesFactory.eINSTANCE.createCompositionListInsertion();
		change.setAddedElement(newPara);
		change.setAffectedElement(section1);
		change.setFeature(newPara.eContainingFeature());
		change.setIndex(targetIdx);
		changes.getChanges().add(change);
	}

}
