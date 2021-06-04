package com.company;

import java.util.Arrays;

public class SimulatedAnneling {

    int[] s;  //navkljucno stanje
    int queens;

    public SimulatedAnneling(int n) {
        this.queens = n;
        s = Util.generateRandomState(n);

    }

    public int[] simulatedAnnealing(int n, double temp, double tempChange) {

        int heuristic = Util.getHeuristic(s);
        int row, col, currentCost, deltaCost;
        double probability;

        if (temp == 0.0)
            return s;

        while (heuristic != 0) {
            col = (int) (Math.random() * n);
            do {
                row = (int) (Math.random() * n);
            } while (s[col] == row);

            int[] x = Arrays.copyOf(s, n);
            x[col] = row; //novo moguce stanje randomly izabrano

            currentCost = Util.getHeuristic(x);
            deltaCost = currentCost - heuristic;

            if (deltaCost < 0) { // bolje stanje
                s = Arrays.copyOf(x, n);
                heuristic = currentCost;
            } else {
                probability = Math.exp((-1) * (deltaCost / temp));  // izaberi random stanje
                if (Math.random() <= probability) {
                    s = Arrays.copyOf(x, n);
                    heuristic = currentCost;
                }
            }

            temp = temp - tempChange;
        }

        return s;
    }

    public int[] getS() {
        return s;
    }
}


