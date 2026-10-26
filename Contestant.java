/**

 * Author: Sabrina

 * Date: October 2026

 * Purpose: Represents a contestant and tracks position data.

 */

public class Contestant extends Person {



    private int totalPositions;

    private int roundsCount;



    public Contestant(String name) {

        super(name);

        this.totalPositions = 0;

        this.roundsCount = 0;

    }



    public void recordPosition(int pos) {

        totalPositions += pos;

        roundsCount++;

    }



    public double getAveragePosition() {

        if (roundsCount == 0) {

            return 0.0;

        }

        return (double) totalPositions / roundsCount;

    }

}


