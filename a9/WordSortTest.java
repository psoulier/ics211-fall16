import static org.junit.Assert.*;

import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.junit.Test;

class StringComparator  implements Comparator<String> {
	public int compare(String a, String b) {
	    if (a == b) {
	        return 0;
	    }
	    
	    if (a == null) {
	        return -1;
	    }
	    
	    if (b == null) {
	        return 1;
	    }
	    
	    return a.compareTo(b);
	}
}

public class WordSortTest {
	
	/**
	 * Loads words from file into a String array.
	 * 
	 * @param inFile String containing path to input file.
	 * @return String array of words. 
	 */
	static String[] loadWords(String inFile) {
		ArrayList<String>	words = new ArrayList<>();
		String[]			word_arr;
		BufferedReader 		br = null;
		
		try {
			FileInputStream inStream = new FileInputStream(inFile);
			
			br = new BufferedReader(new InputStreamReader(inStream));
			String			line;
			
			line = br.readLine();
			while (line != null) {
				words.add(line);
				line = br.readLine();
			}
			
			br.close();
		}
		catch (IOException ioe) {
			System.out.println("Working Directory = " + System.getProperty("user.dir"));
			System.out.println("Error reading file: " + ioe);
			fail("Error reading file.");
		}
		
		word_arr = new String[words.size()];
		words.toArray(word_arr);
		
		return word_arr;
	}

	/**
	 * Checks if String array is sorted in order.
	 * 
	 * @param arr Array to check.
	 */
	static void checkOrder(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			assertTrue(arr[i].compareTo(arr[i+1]) <= 0);
		}		
	}
	
	/**
	 * Simple test to check if sort works for a simple case. 
	 * 
	 * This is a good test to start debugging if the sort methods aren't working.
	 */
	@Test
	public void testSimple() {
		ArraySort<String>		as = new ArraySort<>();
		String[]				strArr = {"a", "z", "e", "w", "t", "s"};
		StringComparator		strCmp = new StringComparator();
		
		// Test bubble sort...
		as.bubbleSort(strArr, strCmp);	
		checkOrder(strArr);
	}
	
	/**
	 * Example test that loads and sorts words from a file.
	 */
	@Test
	public void testWords1000() {
		ArraySort<String>	as = new ArraySort<>();
		StringComparator	strCmp = new StringComparator();
		String[]			words;
		
		words = loadWords("A10-1000-words.txt");
		as.bubbleSort(words, strCmp);	
		checkOrder(words);
	}
	
}
