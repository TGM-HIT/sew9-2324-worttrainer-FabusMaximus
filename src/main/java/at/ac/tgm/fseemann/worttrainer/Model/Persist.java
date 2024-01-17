package at.ac.tgm.fseemann.worttrainer.Model;

/**
 * Abstrakte Klasse Persist.
 *
 * @author Fabian Seemann
 * @version 16.01.2024
 */
public abstract class Persist {
    protected Rechtschreibtrainer trainer;

    public abstract void save();

    public abstract void load();

    /**
     * Gibt den Rechtschreibtrainer zurück.
     *
     * @return der Rechtschreibtrainer.
     */
    public Rechtschreibtrainer getTrainer() {
        return trainer;
    }

    /**
     * Konstruktor der Klasse Persist.
     *
     * @param trainer Der Rechtschreibtrainer der übergeben wird.
     */
    public Persist(Rechtschreibtrainer trainer) {
        this.trainer = trainer;
    }
}
