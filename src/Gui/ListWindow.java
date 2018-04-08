package Gui;

import com.company.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa opisująca okno najlepszych wynikow
 */
public class ListWindow extends JFrame {

    /**
     * Etykieta tabeli najlepszych wynikow
     */
    private JLabel listTitle;
    /**
     * Pole tekstowe zawierajace najlepsze wyniki
     */
    private JTextArea jTextArea;

    /**
     * Konstruktor klasy ListWindow
     */
    public ListWindow() {

        super("Lista wynikow");
        this.setSize(new Dimension(Constants.mainMenuFrameWidth, Constants.mainMenuFrameHeight));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        startListGui();


    }

    /**
     * Inicializator interfejsfu graficznego okna najlepszych wynikow
     */
    private void startListGui() {
        this.setLayout(new BorderLayout());
        this.listTitle = new JLabel("Lista najlepszych wynikow:", 0);
        this.jTextArea = new JTextArea();
        this.jTextArea.setEditable(false);
        this.listTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(listTitle, BorderLayout.NORTH);
        this.add(jTextArea, BorderLayout.CENTER);
    }
}
