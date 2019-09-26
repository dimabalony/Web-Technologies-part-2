package com.company;

public class Coffee extends CoffeeRecipe {
    public Coffee(String title, double coffeeMl, int preparingTime, double waterMl) {
        this.title = title;
        this.coffeeMl = coffeeMl;
        this.preparingTimeSec = preparingTime;
        this.waterMl = waterMl;
    }
}
