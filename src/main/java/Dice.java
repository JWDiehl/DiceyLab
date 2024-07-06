import java.util.Random;

public class Dice {
    //Create a Dice class that acts like a set of N random-tossed dies.

    //Initialize number of dice and a random variable
    private int numberofDice;
    private Random random;

    public Dice(int numberOfDice) {
        this.numberofDice = numberOfDice;
        this.random = new Random();
    }

    public int tossAndSum() {
        int sum = 0;
        int numberOfDice = 0;
        for (int i = 0; i < numberofDice; i++) {
            //For rolling a single die it would be 1 to 6 always
            sum += random.nextInt(6) + 1;
        }
        return sum;
    }

//    public int getNumberofDice() {
//        return numberofDice;
//    }

}
