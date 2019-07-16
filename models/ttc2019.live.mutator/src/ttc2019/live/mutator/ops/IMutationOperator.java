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

	/**
	 * Applies the mutation on the <code>toMutate</code> document, which
	 * was originally a clone of the <code>source</code> document. Changes
	 * should be recorded to the <code>changes</code> {@link ModelChangeSet}.
	 */
	void apply(DocBook source, DocBook toMutate, ModelChangeSet changes);

}
