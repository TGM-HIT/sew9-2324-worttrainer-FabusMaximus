package at.ac.tgm.fseemann.worttrainer.View;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Klasse Frame.
 *
 * @author Fabian Seemann
 * @version 16.01.2024
 */
public class Frame extends JFrame {
    /**
     * Konstruktor der Klasse Frame.
     *
     * @param panel Das Layout.
     */
    public Frame(JPanel panel) {
        super("Worttrainer");
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 600, 450);
        this.setVisible(true);
    }
}