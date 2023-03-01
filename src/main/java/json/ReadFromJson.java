package json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFromJson {
    /*
    this method will fetch the data from the json file
     */
    public String  readFile(String attribute) throws FileNotFoundException {
        JsonParser jsonParser =new JsonParser();
        FileReader read =new FileReader(System.getProperty("user.dir")+"/TestData/JsonData.json");
        Object obj=jsonParser.parse(read);
        JsonObject json=(JsonObject) obj;
        String value = json.get(attribute).getAsString();
        return value;
    }
}
