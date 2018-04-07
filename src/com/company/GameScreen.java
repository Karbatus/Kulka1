package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

/**
 * Klasa opisująca główne okno gry
 */
public class GameScreen extends JPanel {
    /**
     * Kulka, którą sterujemy w grze
     */
    private Ball ball;
    /**
     * Tablica przeszkód
     */
    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    /**
     * Wyjście z poziomu
     */
    private Portal portal;


    public GameScreen() {
        Parser parser = new Parser();
        if(parser.ball != null){
            ball = parser.ball;
        }
        if(!parser.obstacles.isEmpty()){
            obstacles = parser.obstacles;
        }
        if(parser.portal != null){
            portal = parser.portal;
        }
    }

    /**
     * Ustala początkową wielkość okna
     * @return wielkość okna
     */
    public Dimension getPreferredSize() {
        return new Dimension(Constants.mainMenuFrameWidth,Constants.mainMenuFrameHeight);
    }

    /**
     * Rysuje makietę
     * @param g kontekst graficzny
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(ball != null){
            g.setColor(Ball.color);
            g.fillOval(ball.x, ball.y, ball.width, ball.height);
        }
        if(!obstacles.isEmpty()){
            g.setColor(Obstacle.color);
            for(Obstacle o : obstacles){
                g.fillRect(o.x, o.y, o.width, o.height);
            }
        }
        if(ball != null){
            g.setColor(Portal.color);
            g.fillRect(portal.x, portal.y, portal.width, portal.height);
        }

    }

    /**
     *Tworzy i wyświetla GUI
     */
    public static void createAndShowGUI() {
        JFrame f = new JFrame(Constants.gameTitle);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        f.add(new GameScreen());
        f.pack();
        f.setVisible(true);
    }
}
