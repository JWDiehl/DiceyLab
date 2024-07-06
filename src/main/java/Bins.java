
public class Bins {
    //Create a tracking class Bins that can be used to track these results (from Dice).

    //Array to store and track bin values
    private int[] bins;
    //Min value for bins
    private int minValue;
    //Max value for bins
    private int maxValue;

    //constructor to initialize bins arrays based on min and max values
    public Bins(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.bins = new int [maxValue - minValue + 1];
    }

    public void incrementBin(int result) {
        //check if the result is within our range we created
        if (result>= minValue && result <= maxValue) {
            bins[result - minValue]++;
        } else {
            // if its out of range -->
            System.out.println("Result out of range: " + result);
        }
    }

    public int getCount (int result) {
        //check if the result is within our range we created
        if (result >= minValue && result <= maxValue) {
            return bins[result - minValue];
        } else {
            // if its out of range -->
            System.out.println("Result out of range: " + result);
            return 0;
        }
    }
}
