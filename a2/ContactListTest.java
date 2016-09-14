import static org.junit.Assert.*;

import org.junit.Test;

public class ContactListTest {

	@Test
	public void test() {
		ContactList	cl = new ContactList();
		Contact		c;
		
		cl.add(new Contact("Bob", "Jones", "Student", "808-555-5550", "n/a", "n/a", "bjones@nowhere.net"));
		cl.add(new Contact("John", "Doe", "Student", "808-555-5550", "n/a", "n/a", "johnd@nowhere.net"));
		cl.add(new Contact("Jane", "Doe", "UH", "808-555-5550", "n/a", "n/a", "janed@nowhere.net"));
		cl.add(new Contact("Fred", "Turtleman", "Taco Bell", "808-555-5550", "n/a", "n/a", "ft@nowhere.net"));
		cl.add(new Contact("Malory", "Smith", "Student", "808-555-5550", "n/a", "n/a", "msmith@nowhere.net"));
		
		
		c = cl.get(0);			
		assertTrue(c.getFirstName().equals("Jane"));

		c = cl.get(1);			
		assertTrue(c.getFirstName().equals("John"));

		c = cl.get(2);			
		assertTrue(c.getFirstName().equals("Bob"));

		c = cl.get(3);			
		assertTrue(c.getFirstName().equals("Malory"));

		c = cl.get(4);			
		assertTrue(c.getFirstName().equals("Fred"));
		
		assertEquals(5, cl.size());
	}

}
