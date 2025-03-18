package api.model;

public class UserData {                                                                                                 // Этот класс используется для хранения информации о пользователе, поля класса:
    private Integer id;                                                                                                 // Идентификатор пользователя (целое число)
    private String email;                                                                                               // Электронная почта пользователя
    private String first_name;                                                                                          // Имя пользователя
    private String last_name;                                                                                           // Фамилия пользователя
    private String avatar;                                                                                              // URL или путь к изображению аватара пользователя.

    public UserData() {                                                                                                 // Конструкторы, конструктор по умолчанию, который не инициализирует поля.
    }

    public UserData(Integer id, String email, String first_name, String last_name, String avatar) {                     // Параметризованный конструктор, который позволяет инициализировать все поля класса при создании объекта.
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public Integer getId() {                                                                                            // Методы доступа. геттеры: возвращает значение поля id
        return id;
    }

    public String getEmail() {                                                                                          // Возвращает значение email
        return email;
    }

    public String getFirst_name() {                                                                                     // Возвращает значение поля First_name
        return first_name;
    }

    public String getLast_name() {                                                                                      // Возвращает значение поля Last_name
        return last_name;
    }

    public String getAvatar() {                                                                                         // Возвращает значение поля Avatar
        return avatar;
    }
}                                                                                                                       // Класс UserData используется для организации и управления данными пользователя, предоставляя конструкторы для создания объектов и методы для доступа к их полям.