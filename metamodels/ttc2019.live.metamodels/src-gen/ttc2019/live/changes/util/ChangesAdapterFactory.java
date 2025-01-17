/**
 */
package ttc2019.live.changes.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import ttc2019.live.changes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ttc2019.live.changes.ChangesPackage
 * @generated
 */
public class ChangesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ChangesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ChangesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangesSwitch<Adapter> modelSwitch =
		new ChangesSwitch<Adapter>() {
			@Override
			public Adapter caseModelChangeSet(ModelChangeSet object) {
				return createModelChangeSetAdapter();
			}
			@Override
			public Adapter caseModelChange(ModelChange object) {
				return createModelChangeAdapter();
			}
			@Override
			public Adapter caseElementaryChange(ElementaryChange object) {
				return createElementaryChangeAdapter();
			}
			@Override
			public Adapter caseChangeTransaction(ChangeTransaction object) {
				return createChangeTransactionAdapter();
			}
			@Override
			public Adapter caseCompositionChange(CompositionChange object) {
				return createCompositionChangeAdapter();
			}
			@Override
			public Adapter caseAssociationChange(AssociationChange object) {
				return createAssociationChangeAdapter();
			}
			@Override
			public Adapter caseAttributeChange(AttributeChange object) {
				return createAttributeChangeAdapter();
			}
			@Override
			public Adapter caseAssociationCollectionDeletion(AssociationCollectionDeletion object) {
				return createAssociationCollectionDeletionAdapter();
			}
			@Override
			public Adapter caseCompositionCollectionDeletion(CompositionCollectionDeletion object) {
				return createCompositionCollectionDeletionAdapter();
			}
			@Override
			public Adapter caseAttributeCollectionDeletion(AttributeCollectionDeletion object) {
				return createAttributeCollectionDeletionAdapter();
			}
			@Override
			public Adapter caseAssociationCollectionInsertion(AssociationCollectionInsertion object) {
				return createAssociationCollectionInsertionAdapter();
			}
			@Override
			public Adapter caseCompositionCollectionInsertion(CompositionCollectionInsertion object) {
				return createCompositionCollectionInsertionAdapter();
			}
			@Override
			public Adapter caseAttributeCollectionInsertion(AttributeCollectionInsertion object) {
				return createAttributeCollectionInsertionAdapter();
			}
			@Override
			public Adapter caseAssociationCollectionReset(AssociationCollectionReset object) {
				return createAssociationCollectionResetAdapter();
			}
			@Override
			public Adapter caseCompositionCollectionReset(CompositionCollectionReset object) {
				return createCompositionCollectionResetAdapter();
			}
			@Override
			public Adapter caseAttributeCollectionReset(AttributeCollectionReset object) {
				return createAttributeCollectionResetAdapter();
			}
			@Override
			public Adapter caseAssociationListDeletion(AssociationListDeletion object) {
				return createAssociationListDeletionAdapter();
			}
			@Override
			public Adapter caseCompositionListDeletion(CompositionListDeletion object) {
				return createCompositionListDeletionAdapter();
			}
			@Override
			public Adapter caseAttributeListDeletion(AttributeListDeletion object) {
				return createAttributeListDeletionAdapter();
			}
			@Override
			public Adapter caseAssociationListInsertion(AssociationListInsertion object) {
				return createAssociationListInsertionAdapter();
			}
			@Override
			public Adapter caseCompositionListInsertion(CompositionListInsertion object) {
				return createCompositionListInsertionAdapter();
			}
			@Override
			public Adapter caseAttributeListInsertion(AttributeListInsertion object) {
				return createAttributeListInsertionAdapter();
			}
			@Override
			public Adapter caseAttributePropertyChange(AttributePropertyChange object) {
				return createAttributePropertyChangeAdapter();
			}
			@Override
			public Adapter caseAssociationPropertyChange(AssociationPropertyChange object) {
				return createAssociationPropertyChangeAdapter();
			}
			@Override
			public Adapter caseCompositionPropertyChange(CompositionPropertyChange object) {
				return createCompositionPropertyChangeAdapter();
			}
			@Override
			public Adapter caseCompositionMoveIntoProperty(CompositionMoveIntoProperty object) {
				return createCompositionMoveIntoPropertyAdapter();
			}
			@Override
			public Adapter caseCompositionMoveToList(CompositionMoveToList object) {
				return createCompositionMoveToListAdapter();
			}
			@Override
			public Adapter caseOperationCall(OperationCall object) {
				return createOperationCallAdapter();
			}
			@Override
			public Adapter caseOperationArgument(OperationArgument object) {
				return createOperationArgumentAdapter();
			}
			@Override
			public Adapter caseValueArgument(ValueArgument object) {
				return createValueArgumentAdapter();
			}
			@Override
			public Adapter caseReferenceArgument(ReferenceArgument object) {
				return createReferenceArgumentAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.ModelChangeSet <em>Model Change Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.ModelChangeSet
	 * @generated
	 */
	public Adapter createModelChangeSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.ModelChange <em>Model Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.ModelChange
	 * @generated
	 */
	public Adapter createModelChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.ElementaryChange <em>Elementary Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.ElementaryChange
	 * @generated
	 */
	public Adapter createElementaryChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.ChangeTransaction <em>Change Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.ChangeTransaction
	 * @generated
	 */
	public Adapter createChangeTransactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.CompositionChange <em>Composition Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.CompositionChange
	 * @generated
	 */
	public Adapter createCompositionChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AssociationChange <em>Association Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AssociationChange
	 * @generated
	 */
	public Adapter createAssociationChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AttributeChange <em>Attribute Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AttributeChange
	 * @generated
	 */
	public Adapter createAttributeChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AssociationCollectionDeletion <em>Association Collection Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AssociationCollectionDeletion
	 * @generated
	 */
	public Adapter createAssociationCollectionDeletionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.CompositionCollectionDeletion <em>Composition Collection Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.CompositionCollectionDeletion
	 * @generated
	 */
	public Adapter createCompositionCollectionDeletionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AttributeCollectionDeletion <em>Attribute Collection Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AttributeCollectionDeletion
	 * @generated
	 */
	public Adapter createAttributeCollectionDeletionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AssociationCollectionInsertion <em>Association Collection Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AssociationCollectionInsertion
	 * @generated
	 */
	public Adapter createAssociationCollectionInsertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.CompositionCollectionInsertion <em>Composition Collection Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.CompositionCollectionInsertion
	 * @generated
	 */
	public Adapter createCompositionCollectionInsertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AttributeCollectionInsertion <em>Attribute Collection Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AttributeCollectionInsertion
	 * @generated
	 */
	public Adapter createAttributeCollectionInsertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AssociationCollectionReset <em>Association Collection Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AssociationCollectionReset
	 * @generated
	 */
	public Adapter createAssociationCollectionResetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.CompositionCollectionReset <em>Composition Collection Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.CompositionCollectionReset
	 * @generated
	 */
	public Adapter createCompositionCollectionResetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AttributeCollectionReset <em>Attribute Collection Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AttributeCollectionReset
	 * @generated
	 */
	public Adapter createAttributeCollectionResetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AssociationListDeletion <em>Association List Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AssociationListDeletion
	 * @generated
	 */
	public Adapter createAssociationListDeletionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.CompositionListDeletion <em>Composition List Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.CompositionListDeletion
	 * @generated
	 */
	public Adapter createCompositionListDeletionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AttributeListDeletion <em>Attribute List Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AttributeListDeletion
	 * @generated
	 */
	public Adapter createAttributeListDeletionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AssociationListInsertion <em>Association List Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AssociationListInsertion
	 * @generated
	 */
	public Adapter createAssociationListInsertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.CompositionListInsertion <em>Composition List Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.CompositionListInsertion
	 * @generated
	 */
	public Adapter createCompositionListInsertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AttributeListInsertion <em>Attribute List Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AttributeListInsertion
	 * @generated
	 */
	public Adapter createAttributeListInsertionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AttributePropertyChange <em>Attribute Property Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AttributePropertyChange
	 * @generated
	 */
	public Adapter createAttributePropertyChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.AssociationPropertyChange <em>Association Property Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.AssociationPropertyChange
	 * @generated
	 */
	public Adapter createAssociationPropertyChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.CompositionPropertyChange <em>Composition Property Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.CompositionPropertyChange
	 * @generated
	 */
	public Adapter createCompositionPropertyChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.CompositionMoveIntoProperty <em>Composition Move Into Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.CompositionMoveIntoProperty
	 * @generated
	 */
	public Adapter createCompositionMoveIntoPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.CompositionMoveToList <em>Composition Move To List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.CompositionMoveToList
	 * @generated
	 */
	public Adapter createCompositionMoveToListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.OperationCall <em>Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.OperationCall
	 * @generated
	 */
	public Adapter createOperationCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.OperationArgument <em>Operation Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.OperationArgument
	 * @generated
	 */
	public Adapter createOperationArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.ValueArgument <em>Value Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.ValueArgument
	 * @generated
	 */
	public Adapter createValueArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ttc2019.live.changes.ReferenceArgument <em>Reference Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ttc2019.live.changes.ReferenceArgument
	 * @generated
	 */
	public Adapter createReferenceArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ChangesAdapterFactory
