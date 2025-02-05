package order_tests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.StellarBurgersApi;
import org.example.Order;
import java.util.List;

public class OrderSteps {
    private StellarBurgersApi stellarBurgersApi = new StellarBurgersApi();

    @Step("Создание заказа с ингредиентами")
    public Response createOrderWithIngredients(String token) {
        Response ingredientsResponse = getIngredients();
        List<String> ingredientIds = ingredientsResponse.jsonPath()
                .getList("data.findAll {it.name == 'Флюоресцентная булка R2-D3' || it.name == 'Мясо бессмертных моллюсков Protostomia'}._id");
        Order order = new Order(ingredientIds);
        return stellarBurgersApi.doPostCreateOrders(order, token);
    }

    @Step("Получение ингредиентов")
    public Response getIngredients(){
        return stellarBurgersApi.doGetIngredients();
    }

    @Step("Создание заказа с неверным хешем ингредиентов")
    public Response createOrderWithIncorrectIngredients(){
        return stellarBurgersApi.doPostCreateOrders(OrderTestData.bodyPostCreateOrderWithIncorrectIngredients(), "");
    }

    @Step("Создание заказа без ингредиентов")
    public Response createOrderWithoutIngredients(){
        return stellarBurgersApi.doPostCreateOrders(OrderTestData.bodyPostCreateOrderWithoutIngredients(), "");
    }

    @Step("Получение заказа конкретного пользователя")
    public Response getUserOrders(String token){
        return stellarBurgersApi.doGetUserOrders(token);
    }
}
