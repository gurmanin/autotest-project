import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    @Test
    public void getListUsers() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(401)
                .log().all();
    }
    @Test
    public void createUser() {
        given()
                .body("{\"name\":\"morpheus\",\"job\":\"leader\"}")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(401)
                .log().all();
    }
    @Test
    public void updateUser() {
        given()
                .body("{\"name\":\"morpheus\",\"job\":\"zion resident\"}")
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(401)
                .log().all();
    }
    @Test
    public void deleteUser() {
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(401)
                .log().all();
    }


}