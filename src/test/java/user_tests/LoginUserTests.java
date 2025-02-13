package user_tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.Test;

public class LoginUserTests {
    private UserSteps userSteps = new UserSteps();

    @Test
    @Description("Тест на логин под существующим пользователем")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithExistUser(){
        Response loginUser = userSteps.loginUser();
        loginUser.then().statusCode(200);
    }

    @Test
    @Description("Тест на логин с неверным логином и паролем.")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithIncorrectDataUser(){
        Response loginWithIncorrectDataUser = userSteps.loginWithIncorrectDataUser();
        loginWithIncorrectDataUser.then().statusCode(401);
    }
}
