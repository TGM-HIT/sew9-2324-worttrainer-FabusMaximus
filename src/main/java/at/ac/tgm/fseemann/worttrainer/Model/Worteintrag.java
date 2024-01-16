package at.ac.tgm.fseemann.worttrainer.Model;

/**
 * Klasse Worteintrag.
 * @author Fabian Seemann
 * @version 16.01.2024
 */
public class Worteintrag {

    private String word = "";
    private String url = "";

    /**
     * Konstruktor der Klasse Worteintrag.
     * @param word Das Wort des Worteintrags.
     * @param url Die URL des Worteintrags.
     */
    public Worteintrag(String word, String url) {
        this.url = url;
        this.word = word;
    }

    /**
     * Methode: setWord, setzt das Wort eines Worteintrages.
     * @param word Das Wort welches gesetzt werden soll.
     * @throws IllegalArgumentException Exception, wenn ein ungültiges Wort eingegeben wurde.
     */
    public void setWord(String word) {
        if(word != null) {
            this.word = word;
        } else {
            throw new IllegalArgumentException("Ungültiges Wort!");
        }
    }

    /**
     * Methode getWord, gibt das aktuelle Wort zurück.
     * @return Das Wort welches zurückgegeben wird.
     */
    public String getWord() {
        return  this.word;
    }

    /**
     * Methode: setUrl, setzt die URL eines Worteintrages.
     * @param url Die URL welche gesetzt werden soll.
     * @throws IllegalArgumentException Exception, wenn ein ungültiges Wort eingegeben wurde.
     */
    public void setUrl(String url) {
        if(url != null) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("Ungültige URL!");
        }
    }

    /**
     * Methode: getUrl, gibt die aktuelle Url zurück.
     * @return Die URL welche zurückgegeben wird.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Methode: worteintragAusgabe gibt den aktuellen Worteintrag aus.
     * @return Der Worteintrag bestehend aus dem Wort und der URL.
     */
    public String worteintragAusgabe() {
        return "Worteintrag: " + this.word + ", " + this.url;
    }
}
