package at.ac.tgm.fseemann.worttrainer.Controller;

import at.ac.tgm.fseemann.worttrainer.Model.*;
import at.ac.tgm.fseemann.worttrainer.View.Frame;
import at.ac.tgm.fseemann.worttrainer.View.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * Klasse Controller.
 *
 * @author Fabian Seemann
 * @version 16.01.2024
 */
public class Controller implements ActionListener {
    private Panel panel;
    private Frame frame;
    private Rechtschreibtrainer trainer;
    private Persist persist;

    public Controller() {
        trainer = new Rechtschreibtrainer(new Wortliste());
        persist = new PersistJSON(trainer);
        persist.load();
        trainer = persist.getTrainer();
        panel = new Panel(this);
        frame = new Frame(panel);
        panel.statistikAktualisieren(trainer.getGamesPlayed(), trainer.getGamesWon());
        this.showWord();
    }

    /**
     * Methode: actionPerformed, wenn eine Aktion ausgeführt ist, wird ein Event ausgeführt.
     *
     * @param e Das ActionEvent Objekt
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Zurücksetzen")) {
            this.reset();
            persist.save();
        } else if (e.getActionCommand().equals("Wort hinzufügen")) {
            this.addWord();
            persist.save();
        } else {
            this.check();
            persist.save();
        }
    }

    public static void main(String[] args) {
        Controller control = new Controller();
    }

    /**
     * Methdoe: addWord, fügt ein Wort hinzu.
     */
    public void addWord() {
        String wort = JOptionPane.showInputDialog(null, "Geben Sie das Wort ein: ");
        String url = JOptionPane.showInputDialog(null, "Geben Sie die URL ein: ");
        if (wort != null && url != null) {
            if (trainer == null) {
                Wortliste liste = null;
                try {
                    liste = new Wortliste();
                    liste.addWord(wort, url);
                    trainer = new Rechtschreibtrainer(liste);
                    this.showWord();
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            } else {
                Wortliste liste = trainer.getList();
                try {
                    liste.addWord(wort, url);
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                    liste = null;
                }
                if (liste != null) {
                    trainer.setList(liste);
                }
            }
        }
    }

    /**
     * Methode: showWord, zeigt ein Wort an.
     */
    public void showWord() {
        if (trainer != null) {
            trainer.chooseRandom();
            Worteintrag zufall = trainer.getWorteintrag();
            URL url = null;
            try {
                url = new URL(zufall.getUrl());
            } catch (MalformedURLException e1) {
                JOptionPane.showMessageDialog(null, "URL nicht gefunden: " + e1.getMessage());
                try {
                    Wortliste liste = trainer.getList();
                    liste.deleteWord(trainer.getWorteintrag().getWord());
                } catch (IllegalArgumentException e2) {
                    trainer = null;
                }
            }
            if (url != null) panel.changePicture(url);
        }
    }

    /**
     * überprüft das eingegebene Wort und vergleicht es mit dem aktuellen Wort
     */
    public void check() {
        String wort = panel.getTextFromTextField();
        if (trainer.check(wort)) {
            JOptionPane.showMessageDialog(null, "Das Wort ist richtig geschrieben");
            this.showWord();
        } else {
            trainer.setGamesPlayed(trainer.getGamesPlayed() - 1);
            if (trainer.checkIgnoreCase(wort)) {
                trainer.setGamesWon(trainer.getGamesWon() - 1);
                JOptionPane.showMessageDialog(null, "Die Gro\\u00df-/Kleinschreibung ist falsch");
            } else {
                JOptionPane.showMessageDialog(null, "Das Wort ist falsch");
            }
        }
        panel.statistikAktualisieren(trainer.getGamesPlayed(), trainer.getGamesWon());
    }

    /**
     * Methode: reset, setzt die Werte auf die Standardwerte zurück.
     */
    public void reset() {
        trainer.setGamesPlayed(0);
        trainer.setGamesWon(0);
        panel.statistikAktualisieren(0, 0);
    }
}
