package user_tests;

import org.example.User;
import com.github.javafaker.Faker;
import java.util.UUID;

public class UserTestData {

    private static final Faker faker = new Faker();

    //Существующий пользователь:
    public static User bodyPost() {
        return new User("IFesenko", "ira.surckova2013@yandex.ru", "123456");
    }

    public static User bodyPostUniqueData() {
        String name = faker.name().fullName(); // Генерация случайного имени
        String email = faker.internet().emailAddress(); // Генерация случайного email
        String password = UUID.randomUUID().toString(); // Генерация уникального пароля

        return new User(name, email, password);
    }

    public static User bodyPostNotFullData() {
        return new User("Irina", "ira.surckova2013@yandex.ru", "");
    }

    //Логин пользователя:
    public static User doPostLogin() {
        return new User("IFesenko", "ira.fesenko@yandex.ru", "123456");
    }

    public static User doPostLoginWithIncorrectDataUser() {
        return new User("IFesenkooo", "ira.fesenko@yandex.com", "123456");
    }

    //Изменение данных пользователя:
    public static User doUpdateUserData() {
        return new User("NewName1", "email@new1.com");
    }
}
