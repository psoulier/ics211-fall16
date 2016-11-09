
import java.util.List;

public interface SearchTree<E> {
    /**
     * Inserts item into where it belongs in the tree.
     *
     * The add method will replace an existing element if it contains the
     * same "key" (i.e., the comparator says they're equal).
     * @return true if item is inserted, false if item is already in tree.
     */
    boolean add(E item);

    /**
     * @return true if item is in the tree, false otherwise.
     */
    boolean contains(E item);

    /**
     * @return a reference to the target if found, null if target isn't in the tree.
     */
    E find(E target);

    /**
     * Removes target from the tree.
     * @return a reference to the target if found, null if target isn't in the tree.
     */
    E delete(E target);

    /**
     * Removes target from the tree.
     * @return true if target was in the tree, false otherwise.
     */
    boolean remove(E target);

    /**
     * Returns elements of the tree in "level-order" order.
     * @return List of elements.
     */
    default List<E> levelOrderTraversal() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the maximum depth of the tree.  An empty tree has a depth of 0.
     * @return Max depth.
     */
    default int maxDepth() {
        throw new UnsupportedOperationException();
    }

}

