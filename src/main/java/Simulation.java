import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Simulation {
    //Create a Simulation class whose Constructor takes arguments:
    // numberOfDies to throw numberOfTosses to run

    //Create a simulation where two dies are thrown one million times.
    //Keep track of all results.
    private int numberOfDice;
    private int numberOfTosses;
    private Bins results;

    public Simulation(int numberOfDices, int numberOfTosses) {
        this.numberOfDice = numberOfDice;
        this.numberOfTosses = numberOfTosses;
        this.results = new Bins(numberOfDice, numberOfDice * 6);
    }

    public void runSimulation() {
        Dice dice = new Dice(numberOfDice);

        for (int toss = 0; toss < numberOfTosses; toss++) {
            int total = dice.tossAndSum();
            results.incrementBin(total);
        }
    }

    public String getResultsAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***\n");
        sb.append("Simulation of ").append(numberOfDice).append(" dice tossed for ").append(numberOfTosses).append(" times.\n");

        for (int i = numberOfDice; i <= numberOfDice * 6; i++) {
            int count = results.getCount(i);
            double percentage = (double) count / numberOfTosses * 100;
            sb.append(String.format("%2d : %8d: %4.2f", i, count, percentage)).append(" ");
            sb.append("*".repeat((int) percentage)).append("\n");
        }
        return sb.toString();
    }

    public void printResults() {
        System.out.println(getResultsAsString());
    }

    public void writingResultsToFile(String filename) {
        try(FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(getResultsAsString());
            System.out.println("Results written to " + filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //Simulate throwing 2 die 1,000,000 times
        Simulation sim = new Simulation(2, 1000000);
        sim.runSimulation();
        sim.printResults();

        //Writing results to a file
        String filename = "JonDiehl.md";
        sim.writingResultsToFile(filename);
    }

}

//        //simulating throwing 2 die 1,000,000 times
//        Simulation sim = new Simulation(2, 1000000);
//        sim.runSimulation();
//        sim.printResults();
//    }
//}
