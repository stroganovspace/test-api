package api.steps;

import api.model.UserData;
import java.util.List;

public class EmailValidator {
        public static boolean validateEmails(List<UserData> users) {
            for (UserData user : users) {
                if (!user.getEmail().endsWith("@reqres.in")) {
                    return false; // Найден пользователь с некорректным email
                }
            }
            return true; // Все email корректные
        }
    }
