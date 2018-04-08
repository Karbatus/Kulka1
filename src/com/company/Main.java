package com.company;

import Gui.MenuWindow;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuWindow();
            }
        });
    }
}
