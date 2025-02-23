package api.test;

import api.common.Specifications;
import api.model.UserData;
import org.junit.Test;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    public final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest() {
       Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
       List<UserData> users = given()
               .when()
               .get("api/users?page=2")
               .then().log().all()
               .extract().body().jsonPath().getList("data", UserData.class);
    }
}
