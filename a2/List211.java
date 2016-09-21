import java.util.Comparator;

/**
 * Interface for a list.
 *
 * For all methods that accept an index parameter, if the index is not valid, an
 * IndexOutOfBoundsException will be thrown by the method.
 */
public interface List211<E> {
    /**
     * Adds a new element to the end of the list.
     * @param e Element to add to list.
     */
    boolean add(E e);

    /**
     * Adds a new element to the array list at the specified index.
     *
     * Existing elements greater than and equal to the specified index move by one
     * position.  In other words, if an element is added to position "i", the new
     * element will be at position "i", the
     * existing element previously at "i" becomes "i+1", the element at "i+1" becomes "i+2",
     * etc.  If "index" is greater than the value returned by the size() method,
     * an IndexOutOfBoundsException is thrown.
     *
     * @param index Position in array list to add new element.
     * @param element New element to add.
     */
    void add(int index, E element);

    /**
     * Returns the element at the specified index.
     *
     * If "index" does not refer to a valid element, an IndexOutOfBoundsException
     * is thrown.
     *
     * @param index Position of element to return.
     * @return Element at "index".
     */
    E get(int index);

    /**
     * Removes the element at the specified index and reduces the size
     * of the array list by one.
     *
     * When an element is removed, the array must be compacted.  In other words,
     * if element "i" is removed, element "i+1" must be moved to position "i",
     * "i+2" must be moved to "i+1", etc.  An IndexOutOfBoundsException is thrown
     * if "index" does not reference a valid element.
     *
     * @param index Position in array of element to remove.
     */
    E remove(int index);

    /**
     * Replaces the element at the specified index with "element".
     *
     * An IndexOutOfBoundsException is thrown if "index" does not reference a
     * valid element.
     *
     * @param index Position of element to be replaced.
     * @param element Element to be placed at "index".
     * @return The old element that was at "index" before being replaced by
     * "element".
     */
    E set(int index, E element);

    /**
     * Returns the number of elements in the list.
     * @return The number of elements in the list.
     */
    int size();

    /**
     * Sorts list with insertions sort.
     */
    void insertionSort(Comparator<? super E> compare);

    /**
     * Sorts list with bubble sort.
     */
    void bubbleSort(Comparator<? super E> compare);

    /**
     * Sorts list with selection sort.
     */
    void selectionSort(Comparator<? super E> compare);
}
