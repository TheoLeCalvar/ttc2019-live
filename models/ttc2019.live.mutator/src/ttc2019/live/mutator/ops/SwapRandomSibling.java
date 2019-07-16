package ttc2019.live.mutator.ops;

import java.util.Optional;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import ttc2019.live.changes.ChangesFactory;
import ttc2019.live.changes.CompositionMoveToList;
import ttc2019.live.changes.ModelChangeSet;
import ttc2019.live.docbook.DocBook;

public class SwapRandomSibling extends AbstractMutationOperator implements IMutationOperator {

	private final EClass targetEClass;

	public SwapRandomSibling(String name, EClass targetEClass, Random rnd) {
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

		final Resource targetResource = target.eResource();
		final String containerFragment = targetResource.getURIFragment(target.eContainer());
		final String targetFragment = targetResource.getURIFragment(target);

		final EReference feature = (EReference) target.eContainingFeature();
		@SuppressWarnings("unchecked")
		final EList<EObject> eList = (EList<EObject>) target.eContainer().eGet(feature);
		final int idxTarget = eList.indexOf(target);
		final int idxSwapTo = rnd.nextInt(eList.size());
		eList.move(idxSwapTo, idxTarget);

		// Docbook metamodel only has compositions, no plain associations
		CompositionMoveToList change = ChangesFactory.eINSTANCE.createCompositionMoveToList();
		change.setAffectedElement(getOriginalObject(containerFragment, source, changes));
		change.setFeature(feature);
		change.setMovedElement(getOriginalObject(targetFragment, source, changes));
		change.setIndex(idxSwapTo);
		changes.getChanges().add(change);
	}

}
