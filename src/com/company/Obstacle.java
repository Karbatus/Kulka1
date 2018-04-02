package com.company;

import java.awt.*;

public class Obstacle extends GameObject {
    public static final Color color = Color.BLACK;

    public Obstacle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
