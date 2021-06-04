package com.company;

import java.util.Arrays;

public class HillClimbing {


    int[] s;  //navkljucno stanje
    int queens;

    public HillClimbing(int n) {
        this.queens = n;
        s = Util.generateRandomState(n);
        //s= new int[]{1, 2, 2};

    }

    public int[] hillClimbing(int n, int maxNumOfIterations) {

        int heuristic = Util.getHeuristic(s);

        if (heuristic == 0)
            return s;

        for (int j = 0; j < maxNumOfIterations && heuristic > 0; j++) {

            boolean flag = true;
            int tempH = heuristic;
            for (int col = 0; col < n && flag; col++) {

                for (int row = 0; row < n; row++) {

                    int[] x = Arrays.copyOf(s, n); //lista sa pocetka
                    x[col] = row;
                    int cost = Util.getHeuristic(x);

                    if (heuristic > cost) {
                        s[col] = row;
                        heuristic = cost;
                        flag = false;
                        break;
                    }
                }
            }

            // ako zapnemo na lakoalnom maximumu
            if (tempH == heuristic)
                s = Util.generateRandomState(n);

        }

        return s;
    }


    public int[] getS() {
        return s;
    }

    public static void main(String[] args) {
        HillClimbing hillClimbing = new HillClimbing(5);
        int[] res = hillClimbing.hillClimbing(5, 1);
        for (int i = 0; i < 3; i++)
            System.out.println(res[i]);


    }


}
