import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;

import java.io.FileReader;

public class Utils {
    public static String serialize (Object modelClass){
        return new Gson().toJson(modelClass);
    }

    public static <T> T deserialize (String json, Class<T> modelClass){
        return new Gson().fromJson(json,modelClass);
    }

    @SneakyThrows
    public static JsonElement readJsonFile(String jsonFilePath) {
        JsonElement jsonElement = JsonParser.parseReader(new FileReader(jsonFilePath));
        return jsonElement.getAsJsonObject();
    }
}