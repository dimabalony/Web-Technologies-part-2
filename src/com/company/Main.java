package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<CoffeeRecipe> initialRecipes = new ArrayList<CoffeeRecipe>();
        initialRecipes.add(new Coffee("Espresso", 30, 5, 50));
        CoffeeMachine coffeeMachine = new CoffeeMachine(initialRecipes);

        boolean runLoop = true;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (runLoop) {
            coffeeMachine.showMainMenu();

            String answer = in.readLine();
            switch (answer) {
                case "1":
                    coffeeMachine.showMenu();
                    break;
                case "2":
                    CoffeeRecipe newRecipe =  coffeeMachine.createMenu();
                    coffeeMachine.create(newRecipe);
                    break;
                case "3":
                    coffeeMachine.update();
                    break;
                case "4":
                    break;
                case "5":
                    int removableIndex = coffeeMachine.deleteMenu();
                    coffeeMachine.delete(removableIndex);
                    break;
                case "0":
                    runLoop = false;
                    break;
            }
        }
    }
}
