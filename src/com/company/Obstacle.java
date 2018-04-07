package com.company;

import java.awt.*;

public class Obstacle extends GameObject {
    /**
     * Kolor przeszkody
     */
    public static final Color color = Constants.obstacleColor;

    /**
     *Konstruktor przeszkody
     * @param x Współrzędna x
     * @param y Współrzędna y
     * @param width Szerokość
     * @param height Wysokość
     */
    public Obstacle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
