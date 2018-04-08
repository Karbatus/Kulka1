package com.company;

import java.awt.Color;

/**
 * Klasa opisująca portal - cel każdego poziomu gry
 */
public class Portal extends GameObject {
    /**
     * Kolor portalu
     */
    public static final Color color = Constants.portalColor;

    public Portal(int x, int y, int width){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = width;
    }
}
