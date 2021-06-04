package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {

    private JPanel panelMain;
    private JButton runButton;
    private JButton placementBtn;
    private JLabel queens;
    private JLabel parameters;
    private JLabel algorithm;
    private JLabel maxMoves;
    private JLabel startTemperature;
    private JLabel temperatureChange;
    private JLabel states;
    private JLabel populationSize;
    private JLabel elitisamProcent;
    private JLabel crossoverProbability;
    private JLabel mutationProbability;
    private JLabel maximumGenerations;


    private JLabel heuristcs;
    private JLabel heuristicNumber;


    private JTextField t1x;
    private JTextField sT;
    private JTextField tC;
    private JTextField s;
    private JTextField pS;
    private JTextField eP;
    private JTextField cP;
    private JTextField mP;
    private JTextField mG;


    private JComboBox nQueens;
    private JComboBox algorithms;
    ChessBoard chessBoard = new ChessBoard();
    int[] res;
    int numberOfQueens;
    HillClimbing hillClimbing;
    SimulatedAnneling simulatedAnneling;
    LocalBeamSearch localBeamSearch;
    GeneticAlgorithm geneticAlgorithm;

    ActionListener combo = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (algorithms.getSelectedItem() == "Hill climbing") {

                maxMoves.setVisible(true);
                t1x.setVisible(true);

                startTemperature.setVisible(false);
                temperatureChange.setVisible(false);
                sT.setVisible(false);
                tC.setVisible(false);

                states.setVisible(false);
                s.setVisible(false);

                maximumGenerations.setVisible(false);
                mG.setVisible(false);
                mP.setVisible(false);
                mutationProbability.setVisible(false);
                populationSize.setVisible(false);
                pS.setVisible(false);
                crossoverProbability.setVisible(false);
                cP.setVisible(false);
                elitisamProcent.setVisible(false);
                eP.setVisible(false);

            }
            if (algorithms.getSelectedItem() == "Simulated annealing") {

                maxMoves.setVisible(false);
                t1x.setVisible(false);

                startTemperature.setVisible(true);
                temperatureChange.setVisible(true);
                sT.setVisible(true);
                tC.setVisible(true);

                states.setVisible(false);
                s.setVisible(false);

                maximumGenerations.setVisible(false);
                mG.setVisible(false);
                mP.setVisible(false);
                mutationProbability.setVisible(false);
                populationSize.setVisible(false);
                pS.setVisible(false);
                crossoverProbability.setVisible(false);
                cP.setVisible(false);
                elitisamProcent.setVisible(false);
                eP.setVisible(false);
            }
            if (algorithms.getSelectedItem() == "Local beam search") {

                maxMoves.setVisible(false);
                t1x.setVisible(false);

                startTemperature.setVisible(false);
                temperatureChange.setVisible(false);
                sT.setVisible(false);
                tC.setVisible(false);

                states.setVisible(true);
                s.setVisible(true);

                maximumGenerations.setVisible(false);
                mG.setVisible(false);
                mP.setVisible(false);
                mutationProbability.setVisible(false);
                populationSize.setVisible(false);
                pS.setVisible(false);
                crossoverProbability.setVisible(false);
                cP.setVisible(false);
                elitisamProcent.setVisible(false);
                eP.setVisible(false);

            }
            if (algorithms.getSelectedItem() == "Genetic algorithm") {

                maxMoves.setVisible(false);
                t1x.setVisible(false);

                startTemperature.setVisible(false);
                temperatureChange.setVisible(false);
                sT.setVisible(false);
                tC.setVisible(false);

                states.setVisible(false);
                s.setVisible(false);

                maximumGenerations.setVisible(true);
                mG.setVisible(true);
                mP.setVisible(true);
                mutationProbability.setVisible(true);
                populationSize.setVisible(true);
                pS.setVisible(true);
                crossoverProbability.setVisible(true);
                cP.setVisible(true);
                elitisamProcent.setVisible(true);
                eP.setVisible(true);

            }

        }
    };


    ActionListener position = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (algorithms.getSelectedItem() == "Hill climbing") {

                numberOfQueens = (int) nQueens.getSelectedItem();
                hillClimbing = new HillClimbing(numberOfQueens);

                System.out.println(numberOfQueens);

                res = hillClimbing.getS();
                heuristicNumber.setText(String.valueOf(Util.getHeuristic(res)));

                chessBoard.drawBoard(numberOfQueens);
                for (int i = 0; i < numberOfQueens; i++)
                    chessBoard.drawingQueensAtStart(hillClimbing.getS()[i], i);
            }
            if (algorithms.getSelectedItem() == "Simulated annealing") {

                numberOfQueens = (int) nQueens.getSelectedItem();
                simulatedAnneling = new SimulatedAnneling(numberOfQueens);

                res = simulatedAnneling.getS();
                heuristicNumber.setText(String.valueOf(Util.getHeuristic(res)));

                chessBoard.drawBoard(numberOfQueens);
                for (int i = 0; i < numberOfQueens; i++)
                    chessBoard.drawingQueensAtStart(simulatedAnneling.getS()[i], i);

            }
            if (algorithms.getSelectedItem() == "Local beam search") {
                numberOfQueens = (int) nQueens.getSelectedItem();
                int n = Integer.parseInt(s.getText());
                localBeamSearch = new LocalBeamSearch(numberOfQueens, n);

                res = localBeamSearch.getStates();
                heuristicNumber.setText(String.valueOf(Util.getHeuristic(res)));

                chessBoard.drawBoard(numberOfQueens);
                for (int i = 0; i < numberOfQueens; i++)
                    chessBoard.drawingQueensAtStart(localBeamSearch.getStates()[i], i);

            }
            if (algorithms.getSelectedItem() == "Genetic algorithm") {
                numberOfQueens = (int) nQueens.getSelectedItem();
                int pS1 = Integer.parseInt(pS.getText());
                geneticAlgorithm= new GeneticAlgorithm(numberOfQueens,pS1);

                res=geneticAlgorithm.getChromosomes();
                heuristicNumber.setText(String.valueOf(Util.getHeuristic(res)));

                chessBoard.drawBoard(numberOfQueens);
                for (int i = 0; i < numberOfQueens; i++)
                    chessBoard.drawingQueensAtStart(geneticAlgorithm.getChromosomes()[i], i);

            }// kraj

        }
    };


    ActionListener run = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (algorithms.getSelectedItem() == "Hill climbing") {
                int n = Integer.parseInt(t1x.getText());


                res = hillClimbing.hillClimbing(numberOfQueens, n);
                chessBoard.drawBoard(numberOfQueens);
                if (res != null) {                           //ako je heuristika 0
                    for (int i = 0; i < numberOfQueens; i++) {
                        System.out.println(res[i]);
                        chessBoard.drawingQueens(hillClimbing.getS()[i], i);
                        heuristicNumber.setText(String.valueOf(Util.getHeuristic(res)));
                    }

                } else {                                //ako algoritam nije rijesen do kraja
                    System.out.println("!!!");
                    for (int i = 0; i < numberOfQueens; i++) {
                        System.out.println(hillClimbing.getS()[i]);
                        chessBoard.drawingQueens(hillClimbing.getS()[i], i);
                        heuristicNumber.setText(String.valueOf(Util.getHeuristic(hillClimbing.getS())));
                    }

                }
            } //kraj hill climbing
            if (algorithms.getSelectedItem() == "Simulated annealing") {
                double n = Double.parseDouble(tC.getText());
                double n1 = Double.parseDouble(sT.getText());

                res = simulatedAnneling.simulatedAnnealing(numberOfQueens, n1, n);
                chessBoard.drawBoard(numberOfQueens);

                for (int i = 0; i < numberOfQueens; i++) {
                    System.out.println(res[i]);
                    chessBoard.drawingQueens(res[i], i);
                    heuristicNumber.setText(String.valueOf(Util.getHeuristic(res)));
                }
            }
            if (algorithms.getSelectedItem() == "Local beam search") {
                int n = Integer.parseInt(s.getText());

                res = localBeamSearch.localBeamSearch(numberOfQueens, n);
                chessBoard.drawBoard(numberOfQueens);

                for (int i = 0; i < numberOfQueens; i++) {
                    //System.out.println(res[i]);
                    chessBoard.drawingQueens(res[i], i);
                    heuristicNumber.setText(String.valueOf(Util.getHeuristic(res)));
                }
            }// kraj
            if (algorithms.getSelectedItem() == "Genetic algorithm") {
                int pS1 = Integer.parseInt(pS.getText());
                double eP1 = Double.parseDouble(eP.getText());
                double cP1 = Double.parseDouble(cP.getText());
                double mP1 = Double.parseDouble(mP.getText());
                int mG1 = Integer.parseInt(mG.getText());

                res = geneticAlgorithm.geneticAlgorithm(numberOfQueens,pS1,eP1,cP1,mP1,mG1);
                chessBoard.drawBoard(numberOfQueens);

                for (int i = 0; i < numberOfQueens; i++) {
                    //System.out.println(res[i]);
                    chessBoard.drawingQueens(res[i], i);
                    heuristicNumber.setText(String.valueOf(Util.getHeuristic(res)));
                }




            }// kraj
        }
    };


    public void show() {

        // create main frame
        JFrame frame = new JFrame("App");
        Container content = frame.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout(1, 1));
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(16, 2));
        JPanel data = new JPanel();
        data.setLayout(new GridLayout());


        runButton = new JButton("Run");
        runButton.addActionListener(run);
        placementBtn = new JButton("Placement");
        placementBtn.addActionListener(position);

        queens = new JLabel("Number of queens: ");
        nQueens = new JComboBox();
        nQueens.setSize(5, 10);
        nQueens.addItem(4);
        nQueens.addItem(5);
        nQueens.addItem(6);
        nQueens.addItem(7);
        nQueens.addItem(8);
        nQueens.addItem(9);
        nQueens.addItem(10);
        nQueens.addItem(11);
        nQueens.addItem(12);
        numberOfQueens = nQueens.getSelectedIndex();

        algorithm = new JLabel("Algorithms:");
        algorithms = new JComboBox();
        algorithms.addItem("Hill climbing");
        algorithms.addItem("Simulated annealing");
        algorithms.addItem("Local beam search");
        algorithms.addItem("Genetic algorithm");
        algorithms.addActionListener(combo);

        parameters = new JLabel("Parameters: ");
        maxMoves = new JLabel("Maximum equivalent moves: ");
        t1x = new JTextField(5);
        temperatureChange = new JLabel("Temperature change: ");
        tC = new JTextField(5);
        startTemperature = new JLabel("Start temperature: ");
        sT = new JTextField(5);
        states = new JLabel("States: ");
        s = new JTextField(5);
        populationSize = new JLabel("Population size: ");
        pS = new JTextField(5);
        elitisamProcent = new JLabel("Elitism procent: ");
        eP = new JTextField(5);
        crossoverProbability = new JLabel("Crossover probability: ");
        cP = new JTextField(5);
        mutationProbability = new JLabel("Mutation probability: ");
        mP = new JTextField(5);
        maximumGenerations = new JLabel("Maximum generations: ");
        mG = new JTextField(5);


        heuristcs = new JLabel("Heuristic: ");
        heuristicNumber = new JLabel();


        controls.add(queens);
        controls.add(nQueens);
        controls.add(algorithm);
        controls.add(algorithms);
        controls.add(placementBtn);
        controls.add(runButton);
        // controls.add(parameters);
        controls.add(maxMoves);
        controls.add(t1x);
        controls.add(startTemperature);
        controls.add(sT);
        controls.add(temperatureChange);
        controls.add(tC);
        controls.add(states);
        controls.add(s);
        controls.add(populationSize);
        controls.add(pS);
        controls.add(elitisamProcent);
        controls.add(eP);
        controls.add(crossoverProbability);
        controls.add(cP);
        controls.add(mutationProbability);
        controls.add(mP);
        controls.add(maximumGenerations);
        controls.add(mG);

        data.add(heuristcs);
        data.add(heuristicNumber);

        // add to content pane
        content.add(controls, BorderLayout.EAST);
        content.add(chessBoard, BorderLayout.CENTER);
        content.add(data, BorderLayout.SOUTH);
        // add to content pane
        frame.setSize(1000, 650);
        // can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        new Main().show();

    }
}