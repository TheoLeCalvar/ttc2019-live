/**
 */
package ttc2019.live.bibtex;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Authored Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.bibtex.AuthoredEntry#getAuthors <em>Authors</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.bibtex.BibtexPackage#getAuthoredEntry()
 * @model abstract="true"
 * @generated
 */
public interface AuthoredEntry extends BibTeXEntry {
	/**
	 * Returns the value of the '<em><b>Authors</b></em>' containment reference list.
	 * The list contents are of type {@link ttc2019.live.bibtex.Author}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authors</em>' containment reference list.
	 * @see ttc2019.live.bibtex.BibtexPackage#getAuthoredEntry_Authors()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Author> getAuthors();

} // AuthoredEntry
