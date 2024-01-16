package at.ac.tgm.fseemann.worttrainer.Model;

/**
 * Abstrakte Klasse Persist.
 * @author Fabian Seemann
 * @version 16.01.2024
 */
public abstract class Persist {

    protected Rechtschreibtrainer trainer;

    public abstract void save();
    public abstract void load();


    /**
     * Methode: getTrainer, gibt einen Rechtschreibtrainer zurück.
     * @return Der Rechtschreibtrainer der zurückgegeben wird.
     */
    public Rechtschreibtrainer getTrainer() {
        return this.trainer;
    }

    /**
     * Konstruktor der Klasse Persist.
     * @param trainer Der Rechtschreibtrainer.
     */
    public Persist(Rechtschreibtrainer trainer) {
        this.trainer = trainer;
    }
}
