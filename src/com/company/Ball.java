package com.company;

import java.awt.*;

public class Ball extends GameObject{
    public static final Color color = Color.BLUE;

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
    }
}
