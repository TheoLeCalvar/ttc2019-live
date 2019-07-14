package ttc2019.live.mutator.ops;

import ttc2019.live.changes.ModelChangeSet;
import ttc2019.live.docbook.DocBook;

/**
 * Mutation operator that can be applied to a {@link DocBook}. Should pick its
 * operand randomly within the entity.
 */
public interface IMutationOperator {

	/**
	 * Returns a 3-letter code with the identifier of the operator.
	 */
	String getName();

	void apply(DocBook toMutate, ModelChangeSet changes);

}
