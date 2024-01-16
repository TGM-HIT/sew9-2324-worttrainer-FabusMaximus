package at.ac.tgm.fseemann.worttrainer.Model;

import java.util.LinkedList;

/**
 * Klasse Wortlise.
 * @author Fabian Seemann
 * @version 16.01.2024
 */
public class Wortliste {

    private LinkedList<Worteintrag> list;

    /**
     * Konstruktor der Klasse Wortliste.
     */
    public Wortliste() {
        list = new LinkedList<>();
    }


    public Worteintrag getWord(int index) {
        if (index < list.size() && index >= 0) {
            return list.get(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Methode: getWordPair, gibt die Liste mit den Wortpaaren zurück.
     * @return Die Liste die zurückgegeben wird.
     */
    public LinkedList<Worteintrag> getWordPair() {
        return list;
    }

    /**
     * Methode: addWord, fügt ein Wort in die Liste hinzu.
     * @param word Das Wort aus dem Worteintrag, welches hinzugefügt wird.
     * @param url  Die URL aus dem Worteintrag, welche hinzugefügt wird.
     */
    public void addWord(String word, String url) {
        if (word != null && url != null) {
            Worteintrag worteintrag = new Worteintrag(word, url);
            list.add(worteintrag);
        } else {
            throw new IllegalArgumentException("Ungültiger Worteintrag!");
        }
    }

    /**
     * Methode: deleteWord, löscht ein Wort aus der Liste.
     * @param word Das Wort welches aus der Liste gelöscht werden soll.
     */
    public void deleteWord(String word) {
        if (word != null) {
            for (Worteintrag worteintrag : list) {
                if (worteintrag.getWord().equals(word)) {
                    list.remove();
                }
            }
        }
    }

    /**
     * Methode: listToString, gibt die Inhalte der Worteinträge zurück.
     * @return Die Worteinträge die ausgegeben werden.
     */
    public String listToString() {
        String text = "";
        for(Worteintrag worteintrag: list) {
            text += worteintrag.toString() + ", ";
        }
        return text;
    }
}

