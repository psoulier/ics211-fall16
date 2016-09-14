import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

public class MyArrayListTest {
	static final int MAX=10;

	@Test
	public void testEmpty() {
		MyArrayList<Integer>	ial = new MyArrayList<>();
		
		assertEquals(0, ial.size());
		assertEquals(null, ial.get(0));
	}
	
	/**
	 * Check getting and setting elements from array list.
	 * 
	 * The "get" method is checked a lot in other routines, so here were are
	 * primarily checking the "set" method and some boundary cases for "get".
	 */
	@Test
	public void testGetSet() {
		MyArrayList<Integer>	ial = new MyArrayList<>();
		
		for (int i = 0; i < MAX; i++) {
			ial.add(i);
		}

		for (int i = 0; i < MAX; i+=2) {
			Integer	tmp;
			
			// Set a new value and make sure it returns the expected old value...
			tmp = ial.set(i, i*2);
			assertEquals(new Integer(i), tmp);
			assertEquals(new Integer(i*2), ial.get(i));
		}
		
		// Check invalid indices...
		assertEquals(null, ial.get(-1));
		assertEquals(null, ial.get(MAX+10));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddOutOfBounds() {
		MyArrayList<Integer>	ial = new MyArrayList<>();
		
		ial.add(-1, 100);
	}
	
	@Test
	public void testAddSimple() {
		MyArrayList<Integer>	ial = new MyArrayList<>();
		
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
		MyArrayList<Integer>	ial = new MyArrayList<>();

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
	public void testAddPastEnd() {
		MyArrayList<Integer>	ial = new MyArrayList<>();
		
		// Make array list with [0, 1, 2, ..., MAX-1]
		for (int i = 0; i < MAX; i++) {
			ial.add(i);
		}

		// Add element way past current last element so we get
		// an array list with [0, 1, 2, ..., MAX-1, null, null, ..., -1]
		ial.add(MAX*2-1, -1);
		
		// Make sure the first half is unchanged...
		for (int i = 0; i < MAX; i++) {
			assertEquals(new Integer(i), ial.get(i));
		}
		
		// Check to make sure the intermediate indices are null...
		for (int i = MAX; i < MAX-1; i++) {
			assertTrue(ial.get(i) == null);
		}
		
		// Make sure the last element is -1 and the size is correct...
		assertEquals(new Integer(-1), ial.get(MAX*2-1));
		assertEquals(MAX*2, ial.size());
		
	}
	
	class IntComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return a.compareTo(b);
		}
	}

	
	@Test
	public void testSort() {
		MyArrayList<Integer>	ial = new MyArrayList<>();
		
		ial.add(2);
		ial.add(3);
		ial.add(0);
		ial.add(1);
		
		ial.bubbleSort(new IntComparator());
		
		for (int i = 0; i < 4; i++) {
			assertEquals(new Integer(i), ial.get(i));
		}
	}
	
	@Test
	public void testRemove() {
		/* 
		 * Add code to test removing elements from the array list.  These tests can be added
		 * to separate test case methods (they don't all need to be in here). 
		 * - Test should cover removing from beginning, middle, and end.
		 * - Test should also verify the size of the array list is correct
		 * - Test should check for removing an invalid index (negative or too big).
		 */
	}
}
