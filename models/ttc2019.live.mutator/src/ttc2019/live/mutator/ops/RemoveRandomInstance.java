package ttc2019.live.mutator.ops;

import java.util.Optional;
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
	public void apply(DocBook source, DocBook toMutate, ModelChangeSet changes) {
		final Optional<EObject> oTarget = pickRandomOf(toMutate, targetEClass);
		if (!oTarget.isPresent()) {
			return;
		}
		final EObject target = oTarget.get();

		final String uriFragment = target.eResource().getURIFragment(target);
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

		final EObject targetInSource = source.eResource().getEObject(uriFragment);
		CompositionListDeletion change = ChangesFactory.eINSTANCE.createCompositionListDeletion();
		change.setAffectedElement(targetInSource);
		change.setFeature(feature);
		change.setIndex(idxTarget);
		changes.getChanges().add(change);
	}

}
