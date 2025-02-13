package org.example;

import java.util.List;

public class Order {
    private List<String> ingredients;

    public Order(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Order(String ingredient) {
        this.ingredients = List.of(ingredient);
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
