import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class LegsCounting {
    public static void main(String[] args) {
        System.out.println(countNumberOfLegsOfAllAnimals());
    }

    private static long countNumberOfLegsOfAllAnimals() {
        JSONObject jo = parseDataFromJsonToJsonObject(System.getProperty("user.dir") + "/src/main/java/dataForProject/animals.json");
        return (long) jo.get("pigs") + (long) jo.get("chickens") + (long) jo.get("cows");
    }

    private static JSONObject parseDataFromJsonToJsonObject(String pathToJsonFile) {
        Object jsonObject = null;
        try {
            jsonObject = new JSONParser().parse(new FileReader(pathToJsonFile));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return (JSONObject) jsonObject;
    }
}
