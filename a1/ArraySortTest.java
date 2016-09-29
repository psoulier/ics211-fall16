import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

class ArraySortIntComparator implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}
}

public class ArraySortTest {

	
	static void checkOrder(Integer[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			assertTrue(arr[i] <= arr[i+1]);
		}		
	}
	
	@Test
	public void testSimple() {
		ArraySort<Integer>		as = new ArraySort<>();
		Integer[]				ia = {10, 2, 20, 1, 30, 3};
		Integer[]				tmpArr;
		ArraySortIntComparator	icmp = new ArraySortIntComparator();
		
		// Test bubble sort...
		tmpArr = ia.clone();
		as.bubbleSort(tmpArr, icmp);		
		checkOrder(tmpArr);
		

		// Test selection sort...
		tmpArr = ia.clone();
		as.selectionSort(tmpArr, icmp);		
		checkOrder(tmpArr);

		// Test insertion sort...
		tmpArr = ia.clone();
		as.insertionSort(tmpArr, icmp);		
		checkOrder(tmpArr);
	}

	@Test
	public void testDuplicates() {
		ArraySort<Integer>	as = new ArraySort<>();
		Integer[]			ia = {-3, 2, -3, 1, 30, -3};
		Integer[]			tmpArr;
		ArraySortIntComparator		icmp = new ArraySortIntComparator();
		
		// Test bubble sort...
		tmpArr = ia.clone();
		as.bubbleSort(tmpArr, icmp);		
		checkOrder(tmpArr);

		tmpArr = ia.clone();
		as.selectionSort(tmpArr, icmp);		
		checkOrder(tmpArr);

		tmpArr = ia.clone();
		as.insertionSort(tmpArr, icmp);		
		checkOrder(tmpArr);
	}
	
	
	@Test
	public void testBubbleSingle() {
		ArraySort<Integer>	as = new ArraySort<>();
		ArraySortIntComparator		icmp = new ArraySortIntComparator();
		Integer[]			ia = {10};		
		
		as.bubbleSort(ia, icmp);
		assertTrue(ia[0] == 10);
		
		as.selectionSort(ia, icmp);
		assertTrue(ia[0] == 10);

		as.insertionSort(ia, icmp);
		assertTrue(ia[0] == 10);
	}
	
	@Test
	public void testBig() {
		List<Integer> 		ilist = new ArrayList<Integer>();
		ArraySort<Integer>	as = new ArraySort<>();
		Integer[]			ia;
		
		for (int i = -1000; i < 1000; i++) {
		    ilist.add(i);
		}

		// Shuffle it
		Collections.shuffle(ilist);
		ia = ilist.toArray(new Integer[ilist.size()]);
		as.bubbleSort(ia, new ArraySortIntComparator());
		checkOrder(ia);
		
		Collections.shuffle(ilist);
		ia = ilist.toArray(new Integer[ilist.size()]);
		as.selectionSort(ia, new ArraySortIntComparator());
		checkOrder(ia);
		
		Collections.shuffle(ilist);
		ia = ilist.toArray(new Integer[ilist.size()]);
		as.insertionSort(ia, new ArraySortIntComparator());
		checkOrder(ia);
		
	}
	
}
