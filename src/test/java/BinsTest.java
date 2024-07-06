import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinsTest extends TestCase {

    private Bins bins;

    @Before
    public void setUp() {
        //initialize bins with range 1 to 6 (standard 6-sides dice)
        bins = new Bins(1,6);
    }
    @Test
    public void testIncrementBin() {
        bins.incrementBin(3);
        assertEquals(1, bins.getCount(3));
    }

    @Test
    public void testGetCount() {
        bins.incrementBin(4);
        bins.incrementBin(4);
        assertEquals(2, bins.getCount(4));
    }

    @Test
    public void testIncrementBinOutOfRange() {
        //test if its out of range (10)
        bins.incrementBin(10);
        assertEquals(0, bins.getCount(7));
    }

    @Test
    public void testGetCountNotIncremented(){
        // test to see if the loop is not ++ --> therefore it would be 0 which would be wrong
        assertEquals(0, bins.getCount(5));
    }

    @After
    public void tearDown() {}
}