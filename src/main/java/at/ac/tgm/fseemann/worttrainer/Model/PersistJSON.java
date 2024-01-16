package at.ac.tgm.fseemann.worttrainer.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

/**
 * Klasse PersistJSON.
 * @author Fabian Seemann
 * @version 16.01.2024
 */
public class PersistJSON extends Persist {

    public Rechtschreibtrainer rechtschreibtrainer;

    public PersistJSON(Rechtschreibtrainer rechtschreibtrainer) {
        super(rechtschreibtrainer);
    }

    /**
     * Speichert die aktuelle Worttrainersession.
     */
    @Override
    public void save() {
        JSONObject jsonObject = new JSONObject(trainer);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("persist.json");
            fileWriter.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        }
    }

    /**
     * Lädt eine Worttrainersession.
     */
    @Override
    public void load() {
        try {
            Reader input = new FileReader("persist.json");
            Gson gson = new Gson();
            Type type = new TypeToken<Rechtschreibtrainer>(){}.getType();
            trainer = gson.fromJson(input, type);
        }catch (IOException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}
