package order_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import io.restassured.response.Response;
import org.junit.Test;
import user_tests.UserSteps;

public class GetOrdersTests {
    private UserSteps userSteps = new UserSteps();
    private OrderSteps orderSteps = new OrderSteps();

    @Test
    @Description("Получение заказов конкретного пользователя с авторизацией")
    @Severity(SeverityLevel.CRITICAL)
    public void getUserOrders() {
        String token = userSteps.loginUser().jsonPath().getString("accessToken");
        Response getOrder = orderSteps.getUserOrders(token);
        getOrder.then().statusCode(200);
    }

    @Test
    @Description("Получение заказов конкретного пользователя без авторизации")
    @Severity(SeverityLevel.CRITICAL)
    public void getUserOrdersWithoutAuthorization() {
        Response getOrder = orderSteps.getUserOrders("");
        getOrder.then().statusCode(401);
    }
}
