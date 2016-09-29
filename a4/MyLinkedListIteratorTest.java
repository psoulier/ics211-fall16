import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import java.util.ListIterator;
import org.junit.Test;

public class MyLinkedListIteratorTest {
    static final int MAX = 10;

    static <E> void checkNoNext(ListIterator<E> it) {
        try {
            it.next();
            fail("Shouldn't get here.");
        }
        catch (NoSuchElementException e) {
            // Should get here.
        }
        catch (Exception e) {
            fail("Shouldn't get here either.");
        }
    }

    static <E> void checkNoPrev(ListIterator<E> it) {
        try {
            it.previous();
            fail("Shouldn't get here.");
        }
        catch (NoSuchElementException e) {
            // Should get here.
        }
        catch (Exception e) {
            fail("Shouldn't get here either.");
        }
    }

    /**
     * Make sure iterators work correctly with an empty list.
     */
    @Test
    public void testEmpty() {
        MyLinkedList<Integer>   ill = new MyLinkedList<>();
        ListIterator<Integer>   it = ill.iterator();

        assertFalse(it.hasNext());
        assertFalse(it.hasPrevious());

        checkNoNext(it);
        checkNoPrev(it);
    }

    /**
     * Make sure iterators work correctly with a list of one element.
     */
    @Test
    public void testSingle() {
        MyLinkedList<Integer>   ill = new MyLinkedList<>();
        ListIterator<Integer>   it;
        Integer                 i;

        ill.add(0);

        it = ill.iterator();

        assertTrue(it.hasNext());
        assertFalse(it.hasPrevious());

        checkNoPrev(it);

        i = it.next();
        assertEquals(new Integer(0), i);

        assertFalse(it.hasNext());
        assertTrue(it.hasPrevious());

        checkNoNext(it);
    }

    /**
     * Test a larger list by traversing it forwards and backwards in its
     * entirety.
     */
    @Test
    public void testBackAndForth() {
        MyLinkedList<Integer>   ill = new MyLinkedList<>();
        ListIterator<Integer>   it;
        int                     i;

        // Add some elements...
        for (int chk = -1; chk < MAX+1; chk++) {
            ill.add(chk);
        }

        /*
         * Remove element from the front, back, and middle of list to ensure all
         * links/indexing are done properly.  If links/indexing is broken, iterators
         * will behave incorrectly.
         */
        ill.remove(0);
        ill.remove(ill.size() - 1);
        ill.add(MAX/2, 88);
        ill.remove(MAX/2);

        assertEquals(MAX, ill.size());

        // Move forward to the end of list...
        it = ill.iterator();
        i = 0;
        while (it.hasNext()) {
            int j;

            j = it.next();
            assertEquals(j, i);
            i++;

            // Check for excessive looping/infinite loop...
            assertTrue(i <= MAX);
        }

        // Make sure we iterated through the correct number of elements...
        assertEquals(MAX, i);

        while (it.hasPrevious()) {
            i--;
            assertEquals(new Integer(i), it.previous());

            // Check for excessive looping/infinite loop...
            assertTrue(i >= 0);
        }

        // 'i' should be zero if we iterated over the correct number of elements.
        assertEquals(0, i);
    }

    /**
     * Make sure the list class implements the iterable correctly interface by
     * using the 'for' loop that iterates over a container.
     */
    @Test
    public void testFor() {
        MyLinkedList<Integer>   ill = new MyLinkedList<>();

        // Add some elements...
        for (int i = 0; i < MAX; i++) {
            ill.add(i);
        }

        // Make sure the elements were added correctly using the iterator version
        // of a for loop.
        int chk = 0;
        for (Integer i : ill) {
            assertEquals(new Integer(chk), i);
            chk++;
        }
    }

    @Test
    public void testIndex() {
        MyLinkedList<Integer>   ill = new MyLinkedList<>();
        ListIterator<Integer>   it;
        int                     i;

        // Add some elements...
        for (i = 0; i < MAX; i++) {
            ill.add(i);
        }

        it = ill.iterator();
        i = 0;
        while (it.hasNext()) {
            assertEquals(new Integer(i), ill.get(it.nextIndex()));
            it.next();
            i++;

            // Check for excessive looping/infinite loop...
            assertTrue(i <= MAX);
        }

        while (it.hasPrevious()) {
            i--;
            assertEquals(new Integer(i), ill.get(it.previousIndex()));
            it.previous();

            // Check for excessive looping/infinite loop...
            assertTrue(i >= 0);
        }
    }
}
