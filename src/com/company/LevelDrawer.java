package com.company;

import javax.swing.*;
import java.awt.*;

public class LevelDrawer extends JPanel {
    public Dimension getPreferredSize() {
        return new Dimension(450,400);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Parser parser = new Parser();
        if(parser.ball != null){
            g.setColor(Ball.color);
            g.fillOval(parser.ball.x, parser.ball.y, parser.ball.width, parser.ball.height);
        }
        if(!parser.obstacles.isEmpty()){
            g.setColor(Obstacle.color);
            for(Obstacle o : parser.obstacles){
                g.fillRect(o.x, o.y, o.width, o.height);
            }
        }
    }

    /**
     Tworzy i wyświetla GUI
     */
    public static void createAndShowGUI() {
        JFrame f = new JFrame("Kulka");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new LevelDrawer());
        f.pack();
        f.setVisible(true);
    }
}
