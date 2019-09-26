package com.company;

public class CoffeeDrink extends Coffee {
    public double warmMilkMl;
    public double milkFoamMl;

    public CoffeeDrink(String title, double coffeeMl, double waterMl, double warmMilkMl, double milkFoamMl, int preparingTime) {
        super(title, coffeeMl, preparingTime, waterMl);
        this.milkFoamMl = milkFoamMl;
        this.warmMilkMl = warmMilkMl;
    }
}
