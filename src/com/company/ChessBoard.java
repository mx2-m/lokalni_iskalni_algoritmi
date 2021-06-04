package com.company;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;


public class ChessBoard extends JComponent {

    // Image in which we're going to draw
    private Image image;
    // Graphics2D object ==> used to draw on
    private Graphics2D g2;
    /* Toolkit t = Toolkit.getDefaultToolkit();
    Image imageQueen = t.getImage("queen.png");*/


    public ChessBoard() {
        setDoubleBuffered(false);
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // clear draw area
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.white);
        // draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }

    public void red() {
        // apply red color on g2 context
        g2.setPaint(Color.red);
    }


    public void drawingQueens(int x1, int y1) {

        g2.setColor(Color.RED);
        g2.fillOval(x1 * 47, y1 * 47, 47, 47);
        //g2.drawImage(imageQueen,x1,50,50,50,this);
        //g2.finalize();

        repaint();
    }

    public void drawingQueensAtStart(int x1, int y1) {

        g2.setColor(Color.RED);
        g2.fillOval(x1 * 47, y1 * 47, 47, 47);
        repaint();
    }

    public void drawBoard(int N) {
        clear();

        int x, y;
        for (int row = 0; row < N; row++) {

            for (int col = 0; col < N; col++) {

                // Set x coordinates of rectangle by 47 times
                x = row * 47;

                // Set y coordinates of rectangle by 47 times
                y = col * 47;

                // Check whether row and column are in even position
                // If it is true set Black color
                if ((row % 2 == 0) == (col % 2 == 0))
                    g2.setColor(Color.BLACK);
                else
                    g2.setColor(Color.WHITE);

                // Create a rectangle with length and breadth of 40
                g2.fillRect(x, y, 47, 47);

                repaint();

            }
        }
    }
}

