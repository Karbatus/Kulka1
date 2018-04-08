package com.company;

import java.awt.*;

/**
 * Klasa opisująca kulkę sterowaną przez gracza
 */
public class Ball extends GameObject{
    /**
     * Kolor kulki
     */
    public static final Color color = Constants.ballColor;

    /**
     * Konstruktor kulki
     * @param x Współrzędna x
     * @param y Współrzędna y
     */
    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.width = Constants.ballRadius;
        this.height = Constants.ballRadius;
    }
}
