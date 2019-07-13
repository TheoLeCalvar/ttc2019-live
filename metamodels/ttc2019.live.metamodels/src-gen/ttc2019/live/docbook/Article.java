/**
 */
package ttc2019.live.docbook;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Article</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.docbook.Article#getSections_1 <em>Sections 1</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.docbook.DocbookPackage#getArticle()
 * @model
 * @generated
 */
public interface Article extends TitledElement {
	/**
	 * Returns the value of the '<em><b>Sections 1</b></em>' containment reference list.
	 * The list contents are of type {@link ttc2019.live.docbook.Sect1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections 1</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections 1</em>' containment reference list.
	 * @see ttc2019.live.docbook.DocbookPackage#getArticle_Sections_1()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Sect1> getSections_1();

} // Article
