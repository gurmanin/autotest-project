import com.google.gson.JsonElement;
import io.restassured.http.ContentType;
import models.ExampleModel;
import models.InvalidProfileModel;
import models.InvalidProfileModel;
import models.ValidProfileModel;
import net.minidev.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    @Test
    public void createUser() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", "2222");
        requestBody.put("usermame", "QA");
        given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getListUsers() {
        given()
                .when()
                .get("https://petstore.swagger.io/v2/user/QA")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void updateUser() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("usermame", "QA");
        given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .put("https://petstore.swagger.io/v2/user/gurmanin")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void deleteUser() {
        given()
                .when()
                .delete("https://petstore.swagger.io/v2/user/gurmanin")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void test(){
    JsonElement json = Utils.readJsonFile("src/test/resources/example.json");
    ExampleModel formated = Utils.deserialize(json.getAsJsonObject().toString(), ExampleModel.class);
    System.out.println(formated);
    String finalJson = Utils.serialize(formated);
    System.out.println(finalJson);
    }

    //Пример теста когда не будет выполняться условие прописанное в классе InvalidProfileModel для поля age
    @Test
    public void createProfileDenis(){
        InvalidProfileModel profileDenis = new InvalidProfileModel(35,"Denis,","pc","C++");
        System.out.println(profileDenis);
        profileDenis.age = 20;
        System.out.println(profileDenis);
    }

    //Пример теста когда  будет выполняться условие прописанное в классе ValidProfileModel для поля age, использование геттеров и сеттеров
    @Test
    public void createProfileAnton(){
        ValidProfileModel profileAnton = new ValidProfileModel();
        profileAnton.setAge(35);
        profileAnton.setName("Anton");
        profileAnton.setLanguage("Java");
        profileAnton.setGame("CS");
        System.out.println("Меня зовут"+ " " + profileAnton.getName()+","+" "+"мне"+" "+profileAnton.getAge()+" "+"лет,"+" я изучаю"+" "+profileAnton.getLanguage()+" и играю в "+profileAnton.getGame());
        profileAnton.setName("");
        System.out.println(profileAnton);

    }
}