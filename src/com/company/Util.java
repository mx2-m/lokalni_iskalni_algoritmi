package com.company;

public class Util {

    // Sve kraljice su u prvom redu
    public static int[] generateAllOneState(int n) {

        return new int[n];
    }

    public static int[] randomizeState(int[] r) {

        for (int i = 0; i < r.length; i++)
            r[i] = (int) (Math.random() * r.length);

        return r;
    }

    public static int[] generateRandomState(int n) {

        return randomizeState(generateAllOneState(n));
    }

    // heuristika
    public static int getHeuristic(int[] s) {
        int h = 0;

        // heuristika se poveca ako se kraljice napadaju
        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i] == s[j] || Math.abs(s[i] - s[j]) == j - i) {

                    h++;
                }
            }
        }

        return h;
    }


  /*  boolean ifConflict(Queens queen1, Queens queen2) {
        return queen1.dX == queen2.dX || queen1.dY == queen2.dY
                || Math.abs(queen1.dX - queen2.dY) == Math.abs(queen1.dY - queen2.dY); // diagonala
    }


    int getHeuristics(List<Queens> queen) {

        int heuristic = 0;
        for (int i = 0; i < queen.size(); i++) {
            for (int j = i + 1; j < queen.size(); j++) {
                if (ifConflict(queen.get(i), queen.get(j))) {
                    heuristic++;
                }
            }
        }
        return heuristic;
    }*/


}
