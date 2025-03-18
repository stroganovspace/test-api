package api.test;

import api.common.Specifications;
import api.model.UserData;
import api.steps.EmailValidator;
import org.junit.Test;
import java.util.List;

import static api.common.Specifications.URL;
import static io.restassured.RestAssured.given;

public class ReqresTests {                                                                                              // Класс ReqresTests с модификатором доступа public
    EmailValidator emailValidator = new EmailValidator();                                                               // Создается экземпляр класса EmailValidator с именем emailValidator. Этот класс содержит логику проверки оканчивается ли адрес пользователя на "@reqres.in"

    @Test
    public void checkAvatarAndIdTest() {                                                                                // Этот метод обозначен аннотацией @Test, который указывает на то, что это тестовый метод.
       Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());        // Здесь устанавливаются спецификации для запросов и ответов. requestSpec(URL) определяет базовый URL запросов, а responseSpecOK200(), указывает, что ожидается ответ с кодом (200) - успех.
        List<UserData> users = given()                                                                                  // Объявление переменной Users как списка, содержащего объекты типа UserData.  UserData - класс для представления данных о пользователе. Метод given используется для подготовки запроса
               .when()                                                                                                  // When указывает, что будет выполнен запрос
               .get("api/users?page=2")                                                                              // В этом блоке отправялется Get запрос на эндпоинт "api/users?page=2".
               .then().log().all()                                                                                      // В этом блоке происходит логирование запроса. После выполнения запроса then() позволяет задать ожидания относительно ответа. log()all() используется, чтобы вывести всю информацию о запросе и ответе в консоль для отладки
               .extract().body().jsonPath().getList("data", UserData.class);                                       // Здесь происходит извлечение данных из ответа. Этот код извлекает тело и использует JsonPath для получения списка объектов UserData из поля data в JSON ответе. Это преобразует данные из JSON в список объектов UserData
        emailValidator.checkEmails(emailValidator.validateEmails(users));                                                                           // Выполнение Валидации Email-ов с помощью метода validateEmails объекта emailValidator. Метод проверяет действительны ли email адреса в списке пользовалетей
    }                                                                                                                   // Тест проверяет, что API возвращает корректные данные о пользователях на второй странице и валидирует email-адреса этих пользователей.
}
