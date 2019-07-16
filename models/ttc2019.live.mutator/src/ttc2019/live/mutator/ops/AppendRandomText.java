package ttc2019.live.mutator.ops;

import java.util.Optional;
import java.util.Random;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.github.javafaker.Faker;

import ttc2019.live.changes.AttributePropertyChange;
import ttc2019.live.changes.ChangesFactory;
import ttc2019.live.changes.ModelChangeSet;
import ttc2019.live.docbook.DocBook;

public class AppendRandomText extends AbstractMutationOperator {

	private final EClass targetEClass;
	private final EAttribute targetEAttribute;
	private final Faker faker;

	public AppendRandomText(String name, EClass targetEClass, EAttribute eAttr, Random rnd) {
		super(name, rnd);
		assert targetEClass.getEAllAttributes().contains(eAttr);
		this.targetEClass = targetEClass;
		this.targetEAttribute = eAttr;
		this.faker = new Faker(rnd);
	}

	@Override
	public void apply(DocBook source, DocBook toMutate, ModelChangeSet changes) {
		final Optional<EObject> oTarget = pickRandomOf(toMutate, targetEClass);
		if (!oTarget.isPresent()) {
			return;
		}
		final EObject eob = oTarget.get();
		final String eobFragment = eob.eResource().getURIFragment(eob);

		@SuppressWarnings("unused")
		final String oldValue = (String) eob.eGet(targetEAttribute);
		final String newValue = oldValue + (oldValue.endsWith(".") ? "" : ". ") + faker.lorem().paragraph(1);
		eob.eSet(targetEAttribute, newValue);

		AttributePropertyChange change = ChangesFactory.eINSTANCE.createAttributePropertyChange();
		change.setAffectedElement(getOriginalObject(eobFragment, source, changes));
		change.setFeature(targetEAttribute);
		change.setNewValue(newValue);
		change.setOldValue(oldValue);
		changes.getChanges().add(change);
	}

}
