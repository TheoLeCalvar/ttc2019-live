package ttc2019.solutions.epsilon;

import java.io.File;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.EvlContext;

import ttc2019.live.bibtex.BibtexPackage;
import ttc2019.live.docbook.DocbookPackage;

public class LiveContestDriver {

	public static void main(String[] args) {
		try {
	        Initialize();
	        Load();
	        Run();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    private static String Tool;
    private static String MutantSet;
    private static String SourcePath;
    private static String Mutant;
    private static String MutantPath;
    private static String RunIndex;
    private static long stopwatch;

	private static EvlContext evlContext;

    static void Load() throws EolModelLoadingException
    {
    	stopwatch = System.nanoTime();

    	EmfModel bibtexModel = new EmfModel();
    	bibtexModel.setModelFile(SourcePath);
    	bibtexModel.setMetamodelUri(BibtexPackage.eNS_URI);
    	bibtexModel.setReadOnLoad(true);
    	bibtexModel.setStoredOnDisposal(false);
    	bibtexModel.setName("B");
    	bibtexModel.load();
    	evlContext.getModelRepository().addModel(bibtexModel);

    	EmfModel docbookModel = new EmfModel();
    	docbookModel.setModelFile(MutantPath);
    	docbookModel.setMetamodelUri(DocbookPackage.eNS_URI);
    	docbookModel.setReadOnLoad(true);
    	docbookModel.setStoredOnDisposal(false);
    	docbookModel.setName("D");
    	docbookModel.load();
    	evlContext.getModelRepository().addModel(docbookModel);

    	stopwatch = System.nanoTime() - stopwatch;
        Report(BenchmarkPhase.Load, null);
    }

    static void Initialize() throws Exception
    {
    	stopwatch = System.nanoTime();
    	evlContext = new EvlContext();
 
    	// Make sure that both metamodels are available and loaded
    	BibtexPackage.eINSTANCE.getName();
    	DocbookPackage.eINSTANCE.getName();

		Tool = System.getenv("Tool");
		MutantSet = System.getenv("MutantSet");
		SourcePath = System.getenv("SourcePath");
		Mutant = System.getenv("Mutant");
		MutantPath = System.getenv("MutantPath");
		RunIndex = System.getenv("RunIndex");    	

        stopwatch = System.nanoTime() - stopwatch;
        Report(BenchmarkPhase.Initialization, null);
    }

    static void Run() throws Exception
    {
        stopwatch = System.nanoTime();

        EvlModule module = new EvlModule();
        module.setContext(evlContext);
        module.parse(LiveContestDriver.class.getResource("bibtex2docbook.evl").toURI());
        module.execute();

        int problems = 0;
		for (UnsatisfiedConstraint unsatisfiedConstraint : module.getContext().getUnsatisfiedConstraints()) {
			if (unsatisfiedConstraint.getConstraint().isCritique()) {
				if (!unsatisfiedConstraint.getConstraint().isInfo()) {
					problems++;
				}
			}
			else {
				problems++;
			}
		}
        
        stopwatch = System.nanoTime() - stopwatch;
        Report(BenchmarkPhase.Run, Integer.toString(problems));
    }

    static void Report(BenchmarkPhase phase, String result)
    {
        System.out.println(String.format("%s;%s;%s;%s;%s;%s;Time;%s", Tool, MutantSet, new File(SourcePath).getName(), Mutant, RunIndex, phase.toString(), Long.toString(stopwatch)));

        if ("true".equals(System.getenv("NoGC"))) {
			// nothing to do
		} else {
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().gc();
		}
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(String.format("%s;%s;%s;%s;%s;%s;Memory;%s", Tool, MutantSet, new File(SourcePath).getName(), Mutant, RunIndex, phase.toString(), Long.toString(memoryUsed)));

        if (result != null)
        {
            System.out.println(String.format("%s;%s;%s;%s;%s;%s;Problems;%s", Tool, MutantSet, new File(SourcePath).getName(), Mutant, RunIndex, phase.toString(), result));
        }
    }

    enum BenchmarkPhase {
        Initialization,
        Load,
        Run
    }
}
