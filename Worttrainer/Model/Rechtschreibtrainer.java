package Model;

import java.util.Map;
import java.util.Random;

public class Rechtschreibtrainer {

    Map<String, String> words;
    String currentWord;
    int win, loose;

    public String getCurrentWord() {
        return currentWord;
    }

    public String getImage() {
        return this.words.get(this.currentWord);
    }

    public int getWin() {
        return win;
    }

    public int getLoose() {
        return loose;
    }

    public int gameCount() {
        return this.win + this.loose;
    }

    public Rechtschreibtrainer(Map<String, String> words, String currentWord, int win, int loose) {
        this.words = words;
        this.currentWord = currentWord;
        this.win = win;
        this.loose = loose;
    }

    public Rechtschreibtrainer() {

    }

    public void game() {
        Random random = new Random();
        int number = random.nextInt(this.words.size())-1;
        game(number);
    }

    public void game(int index) {
        this.currentWord = this.words.keySet().toArray(new String[this.words.size()])[index];
    }

    public boolean check(String input) {
        if(this.currentWord.equals(input)) {
            this.win++;
            return true;
        } else {
            this.loose++;
            return false;
        }
    }
}