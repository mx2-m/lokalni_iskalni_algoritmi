package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class GeneticAlgorithm {

    int populationSize;
    int[][] chromosomes;
    int n;

    public GeneticAlgorithm(int n, int populationSize) {
        this.populationSize = populationSize;
        this.n = n;
        chromosomes = new int[populationSize][]; //navkljucno tvorena stanja
        for (int i = 0; i < populationSize; i++) {
            chromosomes[i] = Util.generateRandomState(n);
        }

    }

    public int[] geneticAlgorithm(int n, int populationSize, double elitism, double crossover, double mutation, int geneNum) {

        int elitismNum = (int) (populationSize * elitism); // neposredno napreduje v nasljednjo generacijo, neka vrsta kloniranja najboljih rijesenja

        for (int time = 0; time < geneNum; time++) {
            Arrays.sort(chromosomes, new Comparator<int[]>() { // sortiranje hromosoma
                public int compare(int[] o1, int[] o2) {
                    Integer i1 = Util.getHeuristic(o1);
                    Integer i2 = Util.getHeuristic(o2);
                    return i1.compareTo(i2);
                }
            });

            if (Util.getHeuristic(chromosomes[0]) == 0) { // ako imamo rjesenje
                return chromosomes[0];
            }

            for (int i = 0; i < chromosomes.length; i += 2) {
                if (crossover >= Math.random()) { // odstotek krizanja
                    int crossoverPosition = (int) (Math.random() * n); //random pozicija v hromosomu

                    for (int j = 0; j < crossoverPosition; j++) { //izmjenjamo hromosome po indexu sve do pozicije krizanja
                        int temp = chromosomes[i][j];
                        chromosomes[i][j] = chromosomes[i + 1][j];
                        chromosomes[i + 1][j] = temp;
                    }

                    if (Util.getHeuristic(chromosomes[i]) == 0) //ako je nadjeno rjesenje
                        return chromosomes[i];
                    else if (Util.getHeuristic(chromosomes[i + 1]) == 0)
                        return chromosomes[i + 1];
                }
            }

            for (int i = chromosomes.length - 1; i >= elitismNum; i--) { // najbolje izostavimo iz mutacije
                if (mutation >= Math.random()) {                         //mutacija razbija monotonost populacije obicno nije veca od 5%
                    chromosomes[i][(int) (Math.random() * n)] = (int) (Math.random() * n); // izmjeni jedan index
                    if (Util.getHeuristic(chromosomes[i]) == 0)
                        return chromosomes[i];
                }
            }
        }

        return null;
    }

    public int[] getChromosomes() {
        for (int i = 0; i < chromosomes.length; i++)
            return chromosomes[i];
        return null;
    }
}
