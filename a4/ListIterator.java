import java.util.Iterator;

/**
 * Interface definition for iterator.
 *
 * ListIterator must extend the Java Iterator interface.
 */
public interface ListIterator<E> extends Iterator<E> {
    /**
     * Tells caller if there's a next element beyond the current iterator position
     * @return true if there is a next element, false otherwise.
     */
    boolean hasNext();

    /**
     * Tells caller if there's a previous element beyond the current iterator position
     * @return true if there is a previous element, false otherwise.
     */
    boolean hasPrevious();

    /**
     * Moves to the next element and returns the item at that position.
     *
     * If this method is called when hasNext would return false, a NoSuchElementException
     * is thrown.
     * @return Item
     */
    E next();

    /**
     * Returns the index of the next element and advances iterator.
     *
     * If this method is called when hasNext would return false, a NoSuchElementException
     * is thrown.
     *
     * @return
     */
    int nextIndex();

    /**
     * Moves to the next element and returns the item at that position.
     *
     * If this method is called when hasPrevious would return false, a NoSuchElementException
     * is thrown.
     *
     * @return Item
     */
    E previous();

    /**
     * Returns the index of the next element and advances iterator.
     *
     * If this method is called when hasPrevious would return false, a NoSuchElementException
     * is thrown.
     *
     * @return
     */
    int previousIndex();
}
