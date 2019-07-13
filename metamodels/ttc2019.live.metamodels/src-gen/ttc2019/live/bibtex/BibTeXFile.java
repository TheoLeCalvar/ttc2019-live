/**
 */
package ttc2019.live.bibtex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bib Te XFile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ttc2019.live.bibtex.BibTeXFile#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see ttc2019.live.bibtex.BibtexPackage#getBibTeXFile()
 * @model
 * @generated
 */
public interface BibTeXFile extends EObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link ttc2019.live.bibtex.BibTeXEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see ttc2019.live.bibtex.BibtexPackage#getBibTeXFile_Entries()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BibTeXEntry> getEntries();

} // BibTeXFile
