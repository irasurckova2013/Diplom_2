package order_tests;

import io.restassured.response.Response;
import org.example.Order;

import java.util.List;

public class OrderTestData {

    public static Order bodyPostCreateOrderWithoutIngredients() {
        return new Order("");
    }

    public static Order bodyPostCreateOrderWithIncorrectIngredients() {
        return new Order("[\"60d3b41abdacab0026a733c6\",\"609646e4dc916e00276b2870\"]");
    }
}
