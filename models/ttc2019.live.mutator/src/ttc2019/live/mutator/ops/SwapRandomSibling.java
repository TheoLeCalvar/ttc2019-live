package ttc2019.live.mutator.ops;

import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

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
	public void apply(DocBook toMutate, ModelChangeSet changes) {
		final EObject target = pickRandomOf(toMutate, targetEClass);
		final EReference feature = (EReference) target.eContainingFeature();
		@SuppressWarnings("unchecked")
		final EList<EObject> eList = (EList<EObject>) target.eContainer().eGet(feature);

		final int idxTarget = eList.indexOf(target);
		final int idxSwapTo = rnd.nextInt(eList.size());
		eList.move(idxSwapTo, idxTarget);

		// Docbook metamodel only has compositions, no plain associations
		CompositionMoveToList change = ChangesFactory.eINSTANCE.createCompositionMoveToList();
		change.setAffectedElement(target.eContainer());
		change.setFeature(feature);
		change.setMovedElement(target);
		change.setIndex(idxSwapTo);
		changes.getChanges().add(change);
	}

}
