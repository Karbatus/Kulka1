package com.company;

import java.util.*;
import java.io.*;

public class Parser {
    public Ball ball;
    public ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    public Parser(){
        parseFile();
    }

    private Properties loadFile(){
        Properties data = new Properties();
        try {
            Reader reader = new FileReader("config.txt");
            data.load(reader);
            reader.close();
            String line = data.toString();
            System.out.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void parseFile(){
        Properties p = loadFile();
        for(String key : p.stringPropertyNames()){
            String values = p.getProperty(key);
            String[] splitValues = values.split(" ");
            if(key.equals("K")){
                ball = new Ball(Integer.parseInt(splitValues[0]), Integer.parseInt(splitValues[1]));
            } else if (key.substring(0,1).equals("P")) {
                obstacles.add(new Obstacle(Integer.parseInt(splitValues[0]), Integer.parseInt(splitValues[1]), Integer.parseInt(splitValues[2]), Integer.parseInt(splitValues[3])));
            }
        }
    }
}
