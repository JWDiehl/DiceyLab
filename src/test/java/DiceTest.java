import org.junit.Assert;
import org.junit.Test;

//import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @Test
    public void testTossAndSum() {
        //In this test, there are two dice
        Dice dice= new Dice(2);
        int result = dice.tossAndSum();
        //Sum of two dice should be between 2 and 12
        Assert.assertTrue(result >= 2 && result <=12);
    }

    @Test
    public void testNumberOfDice() {
        //IN this test, there are 8 dice
        Dice dice = new Dice(8);
        int numberOfDice = dice.getNumberofDice();
        //Ensure the number of dice is correct
        Assert.assertEquals(8, numberOfDice);
    }

}