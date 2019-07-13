/**
 */
package ttc2019.live.docbook;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Doc Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.docbook.DocBook#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.docbook.DocbookPackage#getDocBook()
 * @model
 * @generated
 */
public interface DocBook extends EObject {
	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link ttc2019.live.docbook.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see ttc2019.live.docbook.DocbookPackage#getDocBook_Books()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Book> getBooks();

} // DocBook
