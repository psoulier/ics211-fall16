public interface List211<E> {
  /**
   * Adds a new element to the end of the array list.
   * @param e Element to add to list.
   */
  boolean add(E e);

  /**
   * Adds a new element to the array list at the specified index. 
   * @param index Position in array list to add new element.
   * @param element New element to add.
   */
  void add(int index, E element);

  /**
   * Returns the element at the specified index.
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
   * "i+2" must be moved to "i+1", etc.
   *
   * @param index Position in array of element to remove.
   */
  E remove(int index);

  /**
   * Replaces the element at the specified index with "element".
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
}
