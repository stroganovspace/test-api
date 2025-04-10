package api.test;

import api.common.Specifications;
import api.model.UserData;
import api.steps.AvatarAndId;
import org.junit.Test;
import java.util.List;

import static api.common.Specifications.URL;
import static io.restassured.RestAssured.given;

public class CheckAvatarAndIdTest {
    AvatarAndId avatarAndId = new AvatarAndId();

    @Test
    public void checkAvatarAndIdTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        avatarAndId.checkAvatarsContainIds(users);
    }
}