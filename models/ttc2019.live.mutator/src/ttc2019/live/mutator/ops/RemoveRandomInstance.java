package ttc2019.live.mutator.ops;

import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import ttc2019.live.changes.ChangesFactory;
import ttc2019.live.changes.CompositionListDeletion;
import ttc2019.live.changes.ModelChangeSet;
import ttc2019.live.docbook.DocBook;

/**
 * Removes one object from the containment tree. To simplify things, assumes the
 * deleted element is only linked to the rest of the model through the
 * containment reference from its eContainer.
 */
public class RemoveRandomInstance extends AbstractMutationOperator {

	private final EClass targetEClass;

	public RemoveRandomInstance(String name, EClass targetEClass, Random rnd) {
		super(name, rnd);
		this.targetEClass = targetEClass;
	}

	@Override
	public void apply(DocBook toMutate, ModelChangeSet changes) {
		final EObject target = pickRandomOf(toMutate, targetEClass);
		final EObject eContainer = target.eContainer();
		final EReference feature = (EReference) target.eContainingFeature();

		// Apply the change
		int idxTarget = 0;
		if (feature.isMany()) {
			@SuppressWarnings("unchecked")
			final EList<EObject> eList = (EList<EObject>)eContainer.eGet(feature);

			idxTarget = eList.indexOf(target);
			eList.remove(idxTarget);
		} else {
			target.eUnset(feature);
		}

		// Log the change (cannot link to deleted object - EMF won't save then)
		// Docbook metamodel only has compositions, no plain associations
		CompositionListDeletion change = ChangesFactory.eINSTANCE.createCompositionListDeletion();
		change.setAffectedElement(eContainer);
		change.setFeature(feature);
		change.setIndex(idxTarget);
		changes.getChanges().add(change);
	}

}
