import com.google.gson.JsonElement;
import io.restassured.http.ContentType;
import models.ExampleModel;
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
}