package user_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.example.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangeUserDataTests {
        private UserSteps userSteps = new UserSteps();

        @Before
        public void deleteUserIfExist() {
            userSteps.deleteUserIfExist();
        }

        @Test
        @Description("Тест на изменение данных пользователя с авторизацией")
        @Severity(SeverityLevel.BLOCKER)
        public void UpdateUserDataWithAuthorization() {
            String token = userSteps.loginUser().jsonPath().getString("accessToken");
            userSteps.getUserData(token);
            userSteps.patchUpdateUserData(token).then().statusCode(200);
        }

       @Test
        @Description("Тест на изменение данных пользователя без авторизации")
        @Severity(SeverityLevel.BLOCKER)
        public void UpdateUserDataWithoutAuthorization() {
            userSteps.patchUpdateUserData(" ").then().statusCode(401);
        }

        @After
        public void deleteUser() {
            userSteps.deleteUserIfExist();
        }

}
