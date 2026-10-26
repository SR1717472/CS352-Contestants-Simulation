import java.util.ArrayList;

import java.util.List;



/**

 * Author: Sabrina

 * Date: October 2026

 * Purpose: Driver class to run the contestants simulation.

 */

public class ContestantsDriver {



    public static void main(String[] args) {



        // -------------------------------

        // PART 1: Run 12 rounds with 8 contestants

        // -------------------------------



        int n = 8;

        int rounds = 12;



        List<Contestant> contestants = new ArrayList<>();



        for (int i = 1; i <= n; i++) {

            contestants.add(new Contestant("Contestant " + i));

        }



        System.out.println("Initial list of contestants:");

        for (Contestant c : contestants) {

            System.out.println(c.getName());

        }



        // Run 12 rounds

        for (int r = 0; r < rounds; r++) {

            runOneRound(contestants);

            recordPositions(contestants);

        }



        // Print average positions

        System.out.println("\nAverage positions after " + rounds + " rounds:");

        for (Contestant c : contestants) {

            System.out.println(c.getName() + ": " + c.getAveragePosition());

        }





        // -------------------------------

        // PART 2: Timing experiments

        // -------------------------------



        int[] roundsList = {10, 100, 1000, 10000};



        System.out.println("\nTiming results for n = 43:");

        for (int r : roundsList) {

            long time = runTimedSimulation(43, r);

            System.out.println("Rounds: " + r + " -> " + time + " ms");

        }



        System.out.println("\nTiming results for n = 45000:");

        for (int r : roundsList) {

            long time = runTimedSimulation(45000, r);

            System.out.println("Rounds: " + r + " -> " + time + " ms");

        }

    }





    /**

     * Runs one full round of the game.

     * Each contestant at the front flips a coin and moves

     * either to the front or the end of the list.

     */

    private static void runOneRound(List<Contestant> contestants) {



        int size = contestants.size();



        for (int i = 0; i < size; i++) {



            // Always take the contestant at the front

            Contestant current = contestants.remove(0);



            boolean coin = Math.random() < 0.5;



            if (coin) {

                // correct -> move to front

                contestants.add(0, current);

            } else {

                // incorrect -> move to end

                contestants.add(current);

            }

        }

    }





    /**

     * Records each contestant's position at the end of a round.

     */

    private static void recordPositions(List<Contestant> contestants) {

        for (int i = 0; i < contestants.size(); i++) {

            contestants.get(i).recordPosition(i);

        }

    }





    /**

     * Runs a simulation only for timing purposes.

     * Does NOT record fairness data.

     */

    private static long runTimedSimulation(int n, int rounds) {



        List<Contestant> contestants = new ArrayList<>();



        for (int i = 1; i <= n; i++) {

            contestants.add(new Contestant("Contestant " + i));

        }



        long start = System.currentTimeMillis();



        for (int r = 0; r < rounds; r++) {

            runOneRound(contestants);

        }



        long end = System.currentTimeMillis();



        return end - start;

    }

}