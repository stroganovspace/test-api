package api.steps;

import api.model.UserData;
import org.junit.Assert;

import java.util.List;

public class EmailValidator {                                                                                           // Этот класс предназначен для валидации электронных адресов пользователей
        public boolean validateEmails(List<UserData> users) {                                                    // Статический метод "validateEmails", который принимает на вход список объектов UserData, которые содержат данные пользователей, включая их адреса электронной почты. Метод возвращает boolean значение, которое указывет, все ли адреса электронной почты корректные
            for (UserData user : users) {                                                                               // Метод "validateEmails" выполняет следующие действия: 1) Цикл по списку пользователей: Для каждого объекта UserData в переданном списке "users", метод выполняет проверку
                if (!user.getEmail().endsWith("@reqres.in")) {                                                          // 2) Проверка адреса электронной почты: с помощью метода getEmail() из класса UserData извлекается адрес электронной почты пользователя. Затем проверяется оканчивается адрес электронной почты на строку "@reqres.in".
                    return false;                                                                                       // Возврат результата: Если хотя бы один email не соответсвует этому критерию, не заканчивается на "@reqres.in", метод сразу возвращает false, что означает, что найден пользователь с некорректным email
                }
            }
            return true;                                                                                                // Возврат результата: Если Все email соотвтсвуют критерию, метод возвращает true, что указывает на то, что все email корректные.
        }

        public void checkEmails (boolean isValideEmails) {
            Assert.assertTrue("Ожидалось true, получили false", isValideEmails);
        }
}                                                                                                                       // Данный класс EmailValidator и его метод validateEmails позволяет быстро проверить, соотвутвуют ли адреса электронной почты пользователей определенному домену.
