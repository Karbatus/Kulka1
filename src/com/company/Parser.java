package com.company;

import java.util.*;
import java.io.*;

/**
 * Obiekt parsujący pliki konfiguracyjne z opisem kolejnych poziomów
 */
public class Parser {
    /**
     * Kulka z położeniem wczytanym z pliku
     */
    private Ball ball;
    /**
     * Lista, do której wczytane będą przeszkody
     */
    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    /**
     * Portal z położeniem wczytanym z pliku
     */
    private Portal portal;

    /**
     * Konstruktor klasy Parser
     */
    public Parser(){
        loadLevelData();
    }

    /**
     * Getter kulki
     * @return Kulka
     */
    public Ball getBall(){
        return ball;
    }

    /**
     * Getter przeszkód
     * @return Przeszkody
     */
    public ArrayList<Obstacle> getObstacles(){
        return obstacles;
    }

    /**
     * Getter portalu
     * @return portal
     */
    public Portal getPortal(){
        return portal;
    }

    /**
     * Wczytuje dane o poziomie z pliku
     * @return dane w obiekcie typu Properties
     */
    private Properties loadFile(){
        Properties data = new Properties();
        try {
            Reader reader = new FileReader("ConfigFiles\\config.txt");
            data.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Wczytuje dane o poziomie
     */
    private void loadLevelData(){
        Properties p = loadFile();
        for(String key : p.stringPropertyNames()){
            String values = p.getProperty(key);
            String[] splitValues = values.split(" ");
            if(key.equals("K")){
                ball = new Ball(Integer.parseInt(splitValues[0]), Integer.parseInt(splitValues[1]));
            } else if (key.substring(0,1).equals("P")) {
                obstacles.add(new Obstacle(Integer.parseInt(splitValues[0]), Integer.parseInt(splitValues[1]), Integer.parseInt(splitValues[2]), Integer.parseInt(splitValues[3])));
            } else if (key.equals("W")){
                portal = new Portal(Integer.parseInt(splitValues[0]), Integer.parseInt(splitValues[1]), Integer.parseInt(splitValues[2]));
            }
        }
    }
}
