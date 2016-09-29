import static org.junit.Assert.*;

import org.junit.Test;



public class MyLinkedListTest {
    static final int MAX=10;

    @Test
    public void testEmpty() {
        MyLinkedList<Integer>   ial = new MyLinkedList<>();

        assertEquals(0, ial.size());
        try {
            ial.get(0);
            fail("Bad stuff");
        }
        catch (IndexOutOfBoundsException e) {
        }
    }

    /**
     * Check getting and setting elements from array list.
     *
     * The "get" method is checked a lot in other routines, so here were are
     * primarily checking the "set" method and some boundary cases for "get".
     */
    @Test
    public void testGetSet() {
        MyLinkedList<Integer>   ial = new MyLinkedList<>();

        for (int i = 0; i < MAX; i++) {
            ial.add(i);
        }

        for (int i = 0; i < MAX; i+=2) {
            Integer tmp;

            // Set a new value and make sure it returns the expected old value...
            tmp = ial.set(i, i*2);
            assertEquals(new Integer(i), tmp);
            assertEquals(new Integer(i*2), ial.get(i));
        }

        // Check invalid indices...
        try {
            ial.get(-1);
            fail("Bad stuff");
        }
        catch (IndexOutOfBoundsException e) {
        }

        try {
            ial.get(MAX+10);
            fail("Bad stuff");
        }
            catch (IndexOutOfBoundsException e) {
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOutOfBounds() {
        MyLinkedList<Integer>   ial = new MyLinkedList<>();

        ial.add(-1, 100);
    }

    @Test
    public void testAddSimple() {
        MyLinkedList<Integer>   ial = new MyLinkedList<>();

        // Add some elements...
        for (int i = 0; i < MAX; i++) {
            ial.add(i);
        }

        // Make sure the elements were added correctly.  MAX should be big enough
        // to cause a resize.
        for (int i = 0; i < MAX; i++) {
            assertEquals(new Integer(i), ial.get(i));
        }
    }

    @Test
    public void testAddMiddle() {
        MyLinkedList<Integer>   ial = new MyLinkedList<>();

        // Add two elements so we get [0, MAX-1]
        ial.add(0);
        ial.add(MAX-1);

        // Add elements in the middle so we get [0, 1, 2, 3, ..., MAX-1]
        for (int i = MAX-2; i >= 1; i--) {
            ial.add(1, i);
        }

        // Make sure array list looks good...
        for (int i = 0; i < MAX; i++) {
            assertEquals(new Integer(i), ial.get(i));
        }

        // Test boundaries (add at index 0 and the very end).  Array list
        // should contain [-1, 0, 2, 3, ..., MAX]
        ial.add(0, -1);
        ial.add(ial.size(), MAX);

        // Check contents of array list...
        for (int i = -1; i < MAX+1; i++) {
            assertEquals(new Integer(i), ial.get(i+1));
        }

        // Make sure size is ok...
        assertEquals(MAX+2, ial.size());
    }




    @Test
    public void testSort() {
        MyLinkedList<Integer>   ial = new MyLinkedList<>();

        ial.add(2);
        ial.add(3);
        ial.add(0);
        ial.add(1);
        ial.add(-1);
        ial.add(4);

        ial.bubbleSort(new IntComparator());

        for (int i = -1; i < 5; i++) {
            assertEquals(new Integer(i), ial.get(i+1));
        }
    }


    @Test
    public void testRemove() {
        MyLinkedList<Integer>   ial = new MyLinkedList<>();

        // Add some elements...
        for (int i = 0; i < MAX; i++) {
            ial.add(i);
        }

        // Remove first element and check...
        ial.remove(0);
        assertEquals(MAX-1, ial.size());
        for (int i = 1; i < MAX; i++) {
            assertEquals(new Integer(i), ial.get(i-1));
        }

        // Remove last element and check...
        ial.remove(ial.size() - 1);
        assertEquals(MAX-2, ial.size());
        for (int i = 1; i < ial.size(); i++) {
            assertEquals(new Integer(i), ial.get(i-1));
        }

        /*
         *  Should have a list containing [1, 2, 3, ..., MAX-2] with a size == MAX-2
         */

        // Remove middle element and check...
        assertEquals(new Integer(2), ial.remove(1));
        assertEquals(new Integer(1), ial.get(0));
        assertEquals(new Integer(3), ial.get(1));
        assertEquals(MAX-3, ial.size());

        /*
         *  Should have a list containing [1, 3, 4, ..., MAX-2] with a size == MAX-2
         */

        for (int i = 4; i < ial.size(); i++) {
            assertEquals(new Integer(i), ial.get(i-2));
        }
    }

    @Test
    public void testOutOfBoundsRemove() {
        MyLinkedList<Integer>   ial = new MyLinkedList<>();

        // Add some elements...
        for (int i = 0; i < MAX; i++) {
            ial.add(i);
        }

        try {
            ial.remove(-1);
            fail("Shouldn't get here");
        }
        catch (Exception e) {

        }

        try {
            ial.remove(MAX);
            fail("Shouldn't get here");
        }
        catch (Exception e) {

        }
    }

    @Test
    public void testFillEmptyFill() {
        MyLinkedList<Integer>   ial = new MyLinkedList<>();

        // Add some elements...
        for (int i = 0; i < MAX; i++) {
            ial.add(i);
        }

        // Make sure the elements were added correctly.  MAX should be big enough
        // to cause a resize.
        for (int i = 0; i < MAX; i++) {
            assertEquals(new Integer(i), ial.get(i));
        }

        for (int i = 0; i < MAX; i++) {
            ial.remove(0);
        }

        assertEquals(0, ial.size());

        for (int i = 0; i < MAX; i++) {
            ial.add(i);
        }

        // Make sure the elements were added correctly.  MAX should be big enough
        // to cause a resize.
        for (int i = 0; i < MAX; i++) {
            assertEquals(new Integer(i), ial.get(i));
        }

        assertEquals(MAX, ial.size());
    }

}
