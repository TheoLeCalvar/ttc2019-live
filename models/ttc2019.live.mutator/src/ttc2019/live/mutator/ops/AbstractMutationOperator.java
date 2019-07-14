package ttc2019.live.mutator.ops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import ttc2019.live.docbook.DocBook;

/**
 * Base class for the various mutation operators.
 */
public abstract class AbstractMutationOperator implements IMutationOperator {

	protected final String name;
	protected final Random rnd;

	public AbstractMutationOperator(String name, Random rnd) {
		this.name = name;
		this.rnd = rnd;
	}

	@Override
	public final String getName() {
		return name;
	}

	/**
	 * Picks a random instance of the specified type, with a uniform distribution.
	 */
	protected EObject pickRandomOf(DocBook toMutate, EClass targetEClass) {
		final List<EObject> allOf = new ArrayList<>();
		final TreeIterator<EObject> itContent = toMutate.eAllContents();
		while (itContent.hasNext()) {
			EObject eob = itContent.next();
			if (targetEClass.isSuperTypeOf(eob.eClass())) {
				allOf.add(eob);
			}
		}

		// Apply the change
		if (allOf.isEmpty()) {
			throw new IllegalStateException("No instances of type " + targetEClass.getName() + " found");
		}

		return allOf.get(rnd.nextInt(allOf.size()));
	}
	
}