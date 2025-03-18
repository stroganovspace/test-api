package api.common;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {                                                                                           // Класс Specifications, который используется для настройки спецификаций HTTP-запросов и ответов с помощью библиотеки RestAssured
    public final static String URL = "https://reqres.in/";                                                              // Это статическая константа, которая содержит базовый URL для API, с которым будет взаимодействовать класс. final означает, что значение этой переменной нельзя изменить

    public static RequestSpecification requestSpec(String url) {                                                        // Статический метод, который принимает строку url как параметр и возвращает объект типа requestSpec
        return new RequestSpecBuilder()                                                                                 // RequestSpecBuilder используется для создания спецификации запроса
                .setBaseUri(url)                                                                                        // Устанавливает базовый URI для запросов
                .setContentType(ContentType.JSON)                                                                       // Устанавливает тип содержимого запроса на JSON
                .build();                                                                                               // Создает и возвращает объект RequestSpecification.
    }

    public static ResponseSpecification responseSpecOK200(){                                                            // Это статический метод, который создает спецификацию ответа для успешных запросов, ожидающих статус-код 200 (OK)
        return new ResponseSpecBuilder()                                                                                // Класс в библиотеке REST-assured, который позволяет создавать спецификацию ответа
                .expectStatusCode(200)                                                                  // Указывает, что ожидается статус-код 200
                .build();                                                                                               // Создает и возвращает объект ResponseSpecification.
    }

    public static ResponseSpecification responseSpecError400(){                                                         // Это статический метод, который создает спецификацию ответа ожидающих статус-код 400 (Bed Request)
        return new ResponseSpecBuilder()                                                                                // Класс в библиотеке REST-assured, который позволяет создавать спецификацию ответа
                .expectStatusCode(400)                                                                  // Указывает, что ожидается статус-код 400
                .build();                                                                                               // Создает и возвращает объект ResponseSpecification.
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response){              // Этот статический метод устанавливает спецификации запроса и ответа в статические поля класса RestAssured.
        RestAssured.requestSpecification = request;                                                                     // Устанавливает спецификацию запроса, переданную в метод
        RestAssured.responseSpecification = response;                                                                   // Устанавливает спецификацию ответа, переданную в метод
    }
}                                                                                                                       // Класс Specifications обеспечивает удобный способ создания и управления спецификациями для тестирования API с использованием RestAssured.
                                                                                                                        // Он позволяет легко настраивать базовый URL, тип содержимого, ожидаемые статус-коды и применять эти настройки ко всем запросам и ответам в рамках тестирования