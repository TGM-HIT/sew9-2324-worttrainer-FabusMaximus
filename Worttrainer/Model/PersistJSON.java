package Model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistJSON implements Persist {

    @Override
    public void save(Rechtschreibtrainer trainer) {
        JSONObject object = new JSONObject();
        object.put("name", trainer);
        try {
            FileWriter writer = new FileWriter("../Data/file.json");
            writer.write(object.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Rechtschreibtrainer retrieve() {
        try {
            FileReader reader = new FileReader("../Data/file.json");
            Object o = new JSONParser().parse(reader);
            JSONObject j = (JSONObject) o;
            return (Rechtschreibtrainer) j.get("name");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
