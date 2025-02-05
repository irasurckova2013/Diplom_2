package order_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import io.restassured.response.Response;
import org.junit.Test;
import user_tests.UserSteps;

public class CreateOrderTests {
    private UserSteps userSteps = new UserSteps();
    private OrderSteps orderSteps = new OrderSteps();

    @Test
    @Description("Тест на создание заказа с авторизацией")
    @Severity(SeverityLevel.CRITICAL)
    public void createOrderWithAuthorization() {
        String token = userSteps.loginUser().jsonPath().getString("accessToken");
        Response createOrder = orderSteps.createOrderWithIngredients(token);
        createOrder.then().statusCode(200);
    }

    @Test
    @Description("Тест на создание заказа без авторизации")
    @Severity(SeverityLevel.CRITICAL)
    public void createOrderWithoutAuthorization() {
        Response createOrder = orderSteps.createOrderWithIngredients("");
        createOrder.then().statusCode(200);
    }

    @Test
    @Description("Тест на создание заказа с ингредиентами")
    @Severity(SeverityLevel.CRITICAL)
    public void createOrderWithIngredients() {
        Response createOrder = orderSteps.createOrderWithIngredients("");
        createOrder.then().statusCode(200);
    }

    @Test
    @Description("Тест на создание заказа без ингредиентов")
    @Severity(SeverityLevel.CRITICAL)
    public void createOrderWithoutIngredients() {
        Response createOrder = orderSteps.createOrderWithoutIngredients();
        createOrder.then().statusCode(400);
    }

    @Test
    @Description("Тест на создание заказа c неверным хешем")
    @Severity(SeverityLevel.CRITICAL)
    public void createOrderWithIncorrectIngredients() {
        Response createOrder = orderSteps.createOrderWithIncorrectIngredients();
        createOrder.then().statusCode(500);
    }
}
