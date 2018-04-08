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
    /**
     * Panel z informacjami
     */
    private JPanel textGUI = new JPanel();
    /**
     * Licznik
     */
    private JLabel timeLabel = new JLabel (Constants.timeLabel + Constants.initialTime);
    /**
     * Pole wyświetlające ilość zdobytych punktów
     */
    private JLabel pointsLabel = new JLabel (Constants.pointsLabel + Constants.initialPoints);
    /**
     * Pole wyświetlające pozostałe życia
     */
    private JLabel lifeLabel = new JLabel (Constants.lifeLabelText + Constants.initialLives);

    /**
     * Konstruktor głównego panelu gry. Przypisuje wartości zmiennym i dodaje GUI.
     */
    public GameScreen() {
        Parser parser = new Parser();
        if(parser.getBall() != null){
            ball = parser.getBall();
        }
        if(!parser.getObstacles().isEmpty()){
            obstacles = parser.getObstacles();
        }
        if(parser.getPortal() != null){
            portal = parser.getPortal();
        }
        textGUI.setLayout(new BoxLayout(textGUI, BoxLayout.PAGE_AXIS));
        textGUI.add(timeLabel);
        textGUI.add(lifeLabel);
        textGUI.add(pointsLabel);
        this.add(textGUI);
        this.setBorder(BorderFactory.createEmptyBorder(10,0,0,-500));
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
        JFrame f = new JFrame();
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
