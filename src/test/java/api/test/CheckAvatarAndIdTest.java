package api.test;

import api.common.Specifications;
import api.model.UserData;
import api.steps.AvatarAndId;
import org.junit.Test;
import java.util.List;

import static api.common.Specifications.URL;
import static io.restassured.RestAssured.given;

public class CheckAvatarAndIdTest {                                                                                     // Класс CheckAvatarAndIdTest с модификатором доступа public.
    AvatarAndId avatarAndId = new AvatarAndId();                                                                        // Создается экземпляр класса AvatarAndId с именем avatarAndId. Этот класс содержит логику проверки соответсвия аватарами и иденитфмкаторвами пользователя

    @Test
    public void checkAvatarAndIdTest() {                                                                                // Этот метод обозначен аннотацией Test, который указывает что это тестовый метод
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());       // Здесь устанавливаются спецификации для запросов и ответов. requestSpec(URL) определяет базовый URL запросов, а responseSpecOK200(), указывает, что ожидается ответ с кодом (200) - успех.
        List<UserData> users = given()                                                                                  // Объявление переменной Users как списка, содержащего объекты типа UserData.  UserData - класс для представления данных о пользователе. Метод given() используется для подготовки запроса.
                .when()                                                                                                 // Метод when() указывает что будет выполнен этот запрос.
                .get("api/users?page=2")                                                                             // В этом блоке отправялется Get запрос на эндпоинт "api/users?page=2".
                .then().log().all()                                                                                     // В этом блоке происходит логирование запроса. После выполнения запроса then() позволяет задать ожидания относительно ответа. log()all() используется, чтобы вывести всю информацию о запросе и ответе в консоль для отладки
                .extract().body().jsonPath().getList("data", UserData.class);                                      // Здесь происходит извлечение данных из ответа. Этот код извлекает тело и использует JsonPath для получения списка объектов UserData из поля data в JSON ответе. Это преобразует данные из JSON в список объектов UserData
        avatarAndId.checkAvatarsContainIds(users);                                                                      // Проверка аватаров и идентификаторов с помощью метода "checkAvatarsContainIds" объекта "avatarAndId". Метод проверяет, что все аватары пользователей содержат соответсвующие идентификаторы. То есть для кажждого пользователя проверяется, что его аватар связан с его идентификатором.
    }                                                                                                                   // Тест проверяет, что данные о пользователях, полученные из API, имеют корректные ассоциации между аватарми и идентификаторами
}