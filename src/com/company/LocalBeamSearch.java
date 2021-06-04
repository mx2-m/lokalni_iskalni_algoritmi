package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class LocalBeamSearch {

    int[][] states;
    int numOfStates;

    public LocalBeamSearch(int n, int numOfStates) {
        states = new int[numOfStates][];
        this.numOfStates = numOfStates;   //tvori k navkljucnih zacetnih stanj
        for (int i = 0; i < numOfStates; i++)
            states[i] = Util.generateRandomState(n);

    }


    public int[] localBeamSearch(int n, int numOfStates) {


        for (int x = 0; x < 1000; x++) {

            int[][] newStates = new int[n * numOfStates][];
            for (int i = 0; i < numOfStates; i++) {
                int heuristic = Util.getHeuristic(states[i]);

                // rjeseno
                if (heuristic == 0) {
                    return states[i];
                }

                for (int col = 0; col < n; col++) {
                    newStates[i * n + col] = makeMove(states[i], col, heuristic);


                    if (newStates[i * n + col] == null)
                        newStates[i * n + col] = Util.generateRandomState(n);
                }

            }
            Arrays.sort(newStates, Comparator.comparingInt(Util::getHeuristic));    //sortiramo glede na heuristiku

            states = Arrays.copyOfRange(newStates, 0, numOfStates); //shranimo k najboljsih

        }

        return null;
    }

    private int[] makeMove(int s[], int col, int heuristic) {
        int n = s.length;

        for (int row = 0; row < n; row++) {

            int tmpRow = s[col];
            s[col] = row;
            int cost = Util.getHeuristic(s);
            if (heuristic > cost) {
                s[col] = row;
                return s;

            }
            s[col] = tmpRow;
        }

        return null;
    }

    public int[] getStates() {
        for (int i = 0; i < numOfStates; i++)
            return states[i];
        return null;
    }


}
