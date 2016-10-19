import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import java.util.ListIterator;
import org.junit.Test;

public class FoodlandTest {

    /**
     * Test to ensure simulation completes.
     *
     * This test won't check that the simulation ran correctly; it just tests that it
     * terminates.  The timeout in the @Test annotation has a timeout of 1s.
     */
    @Test(timeout=1000)
    public void testFinishes() {
        CheckoutLanes checkout = new CheckoutLanes(1, 2);

        checkout.enterLane(0, new Shopper(15));
        checkout.enterLane(0, new Shopper(3));
        checkout.enterLane(1, new Shopper(20));
        checkout.enterLane(2, new Shopper(17));

        checkout.simulateCheckout();
    }

    @Test(timeout=1000)
    public void testMovedExpressLaneShopper() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();

        /*
         * Redirect console output.
         */
        System.setOut(new PrintStream(myOut));

        CheckoutLanes checkout = new CheckoutLanes(1, 2);

        checkout.enterLane(0, new Shopper(15));
        checkout.enterLane(0, new Shopper(3));
        checkout.enterLane(1, new Shopper(20));
        checkout.enterLane(2, new Shopper(17));

        checkout.simulateCheckout();

        /*
         * Get output of test as a string and then check for the string "moved".  The
         * program (as shown by the example in the assignment) should have printed a
         * message stating that a shopper was "moved" from an express lane because they
         * had more than 10 items.
         */
        final String stdout = myOut.toString();
        assertTrue(stdout.contains("moved"));
    }


}

