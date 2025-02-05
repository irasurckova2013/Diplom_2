package user_tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateUserTests {
    private UserSteps userSteps = new UserSteps();

    @Before
    public void deleteUserIfExist() {
        userSteps.deleteUserIfExist();
    }

    @Test
    @Description("Тест на создание уникального пользователя")
    @Severity(SeverityLevel.BLOCKER)
    public void createUniqueUser(){
        Response createUser = userSteps.createUser();
        createUser.then().statusCode(200);
    }

    @Test
    @Description("Тест на создание уникального пользователя, который уже зарегистрирован")
    @Severity(SeverityLevel.BLOCKER)
    public void createExistUser(){
        Response createExistUser = userSteps.createExistUser();
        createExistUser.then().statusCode(403);
    }

    @Test
    @Description("Тест на создание пользователя без одного из обязательных полей.")
    @Severity(SeverityLevel.CRITICAL)
    public void createUserNotFullData(){
        Response createUserNotFullData = userSteps.createUserNotFullData();
        createUserNotFullData.then().statusCode(403);
    }

    @After
    public void deleteUser() {
        userSteps.deleteUserIfExist();
    }

}
