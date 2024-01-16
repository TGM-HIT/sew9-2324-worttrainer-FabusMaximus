package at.ac.tgm.fseemann.worttrainer.Model;

import java.util.Random;

/**
 * Klasse Rechtschreibtrainer.
 * @author Fabian Seemann
 * @version 16.01.2024
 */
public class Rechtschreibtrainer {

    private Wortliste list;
    private Worteintrag worteintrag;
    private int played, won;

    /**
     * Konstruktor der Klasse Rechtschreibtrainer.
     * @param list Die Liste die übergeben wird.
     */
    public Rechtschreibtrainer(Wortliste list) {
        this.list = list;
    }

    /**
     * Methode: randomWord, wählt ein zufälliges Wort aus der Liste aus.
     */
    public void randomWord() {
        if(list.getWordPair().size() != 0) {
            Random random = new Random();
            worteintrag = list.getWord(random.nextInt(list.getWordPair().size()));
        }
    }

    /**
     * Methode: indexWord, wählt ein Wort aus der Liste anhand eines Indexes aus.
     * @param index Das Wort aus der Liste an der Stelle dieses Indexes.
     */
    public void indexWord(int index) {
        if(list.getWordPair().size() != 0 && index > 0 && index <= list.getWordPair().size()) {
            worteintrag = list.getWord(index);
        }
    }

    /**
     * Methode: checkWord, kontrolliert, ob das aktuelle Wort mit dem übergebenen Wort übereinstimmt.
     * @param word Das übergebene Wort.
     * @return Gibt zurück ob das Wort richtig oder falsch ist.
     */
    public boolean checkWord(String word) {
        this.played++;
        if(word.toLowerCase().equals(worteintrag.getWord().toLowerCase())) {
            this.won++;
            return true;
        }
        return false;
    }

    /**
     * Methode: toString, ausgabe des Rechtschreibtrainers.
     * @return Die Ausgabe.
     */
    public String toString() {
        String text = this.played + ", " + this.won + "\n";
        text += list.toString();
        return text;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getPlayed() {
        return this.played;
    }

    public void setWon() {
        this.won = won;
    }

    public int getWon() {
        return this.won;
    }

    public void setList(Wortliste list) {
        this.list = list;
    }

    public Wortliste getList() {
        return this.list;
    }

    public Worteintrag getWorteintrag() {
        return this.worteintrag;
    }
}
