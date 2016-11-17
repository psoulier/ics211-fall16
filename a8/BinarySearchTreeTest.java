import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


class TreeIntComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}

public class BinarySearchTreeTest {

    /**
     * Returns a list of integers to populate a balanced tree.
     *
     * The list, when added to a binary tree from 0 to N-1, will produce
     * a balanced tree.  The list is also in the same order a level-order traversal
     * should produce.
     *
     * @param numItems Number of elements to generate.
     * @return List of integers
     */
    List<Integer> balancedList(int numItems) {
        List<Integer>   blist = new ArrayList<Integer>();
        int x = numItems;
        int p = 0;
        int level = 0;

        while (x > 0) {
            x >>= 1;
            p++;
        }

        p = 1 << p;

        while (numItems > 0) {
            int next = p / 2;
            for (int i = 0; i < (1 << level) && numItems > 0; i++) {

                blist.add(next);
                next += p;
                numItems--;
            }

            level++;
            p /= 2;
        }

        return blist;
    }

    /**
     * Tests basic properties of an empty tree.
     */
    @Test
    public void emptyTest() {
        BinarySearchTree<Integer>   btree = new BinarySearchTree<>(new TreeIntComparator());

        assertFalse(btree.contains(0));
        assertFalse(btree.remove(1000));
    }

    /**
     * Test add functionality of tree.
     */
    @Test
    public void testAdd() {
        BinarySearchTree<Integer>   btree = new BinarySearchTree<>(new TreeIntComparator());
        List<Integer>               bl = balancedList(1023);

        // Get a bunch of numbers that will create a balanced tree...
        bl = balancedList(1023);

        // Add the elements to the tree...
        for (Integer i : bl) {
            btree.add(i);
        }

        /*
         * Add the same elements again.  The add method should return true for every
         * one since they should already be in the tree.
         */
        for (Integer i : bl) {
            assertFalse(btree.add(i));
        }
    }

    @Test
    public void testRemove() {
        BinarySearchTree<Integer>   btree = new BinarySearchTree<>(new TreeIntComparator());

        // There's nothing in the tree, must return null.
        assertNull(btree.delete(0));

        /*
         * Create a tree with a structure similar to the one in the slides.
         */
        btree.add(20);
        btree.add(10);
        btree.add(40);
        btree.add(0);
        btree.add(30);
        btree.add(70);
        btree.add(60);
        btree.add(80);
        btree.add(50);

        // Remove a full node.
        assertEquals(new Integer(20), btree.delete(20));
        assertFalse(btree.contains(20));

        // Remove a partial node
        assertTrue(btree.remove(10));
        assertFalse(btree.contains(10));
        assertTrue(btree.contains(0));

        // Remove a leaf
        assertEquals(new Integer(0), btree.delete(0));
        assertFalse(btree.contains(0));
        assertTrue(btree.contains(50));
    }

    @Test
    public void testMaxDepth() {
        BinarySearchTree<Integer>   btree = new BinarySearchTree<>(new TreeIntComparator());
        List<Integer>               bl = balancedList(1023);

        assertEquals(0, btree.maxDepth());

        bl = balancedList(1023);

        for (Integer i : bl) {
            btree.add(i);
        }

        assertEquals(10, btree.maxDepth());
    }

    @Test
    public void testMaxDepthLinear() {
        BinarySearchTree<Integer>   btree = new BinarySearchTree<>(new TreeIntComparator());

        for (int i = 0; i < 16; i++) {
            btree.add(i);
        }

        assertEquals(16, btree.maxDepth());
    }

    @Test
    public void testLevelOrder() {
        BinarySearchTree<Integer>   btree = new BinarySearchTree<>(new TreeIntComparator());
        List<Integer>   lol;

        btree.add(20);
        btree.add(10);
        btree.add(40);
        btree.add(0);
        btree.add(30);
        btree.add(70);
        btree.add(60);
        btree.add(80);
        btree.add(50);

        lol = btree.levelOrderTraversal();

        // List must contain the same number of elements as tree.
        assertEquals(9, lol.size());

        assertEquals(lol.get(0), new Integer(20));
        assertEquals(lol.get(1), new Integer(10));
        assertEquals(lol.get(2), new Integer(40));
        assertEquals(lol.get(3), new Integer(0));
        assertEquals(lol.get(4), new Integer(30));
        assertEquals(lol.get(5), new Integer(70));
        assertEquals(lol.get(6), new Integer(60));
        assertEquals(lol.get(7), new Integer(80));
        assertEquals(lol.get(8), new Integer(50));
    }

    @Test
    public void testLevelOrderBig() {
        BinarySearchTree<Integer>   btree = new BinarySearchTree<>(new TreeIntComparator());
        List<Integer>               bl = balancedList(1023);
        List<Integer>               lol;

        for (Integer i : bl) {
            btree.add(i);
        }

        lol = btree.levelOrderTraversal();

        // Both lists had better be equal.
        assertEquals(bl.size(), lol.size());

        for (int i = 0; i < bl.size(); i++) {
            assertEquals(lol.get(i), bl.get(i));
        }
    }

}

