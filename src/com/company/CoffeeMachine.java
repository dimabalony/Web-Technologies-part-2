package com.company;

import com.company.Services.DataManager;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.SwitchPoint;
import java.sql.SQLOutput;
import java.util.List;

public class CoffeeMachine {
    List<CoffeeRecipe> recipes;

    public CoffeeMachine(List<CoffeeRecipe> recipes) {
        this.recipes = recipes;
    }

    public void showMainMenu() {
        System.out.println("Main menu:");
        System.out.println("1. Show menu.");
        System.out.println("2. Create new recipe.");
        System.out.println("3. Read recipe");
        System.out.println("4. Update recipe");
        System.out.println("5. Delete recipe");
        System.out.println("0. Exit.");
    }

    void showMenu() {
        int index = 1;
        System.out.println("Current Menu:");
        for (CoffeeRecipe coffee : recipes) {
            System.out.println(index++ + ". " + coffee.title + ".");
        }
    }

    public CoffeeRecipe createMenu() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose type of coffee");
        System.out.println("1. Coffee (only coffee)");
        System.out.println("2. Coffee drink (coffee with milk)");
        String answer = in.readLine();
        String title;
        System.out.println("Enter title");
        title = in.readLine();
        
        double coffeeMl;
        System.out.println("Enter Coffee Ml");
        coffeeMl = Double.parseDouble(in.readLine());

        double waterMl;
        System.out.println("Enter Water Ml");
        waterMl = Double.parseDouble(in.readLine());

        double warmMilkMl = 0;
        double milkFoamMl = 0;
        switch (answer) {
            case "2":
                System.out.println("Enter Warm Milk Ml");
                warmMilkMl = Double.parseDouble(in.readLine());
                
                System.out.println("Enter Milk Foam Ml");
                milkFoamMl = Double.parseDouble(in.readLine());
                break;
            case "1": break;
            default:
                throw new IllegalStateException("Unexpected value: " + answer);
        }

        int preparingTimeSec;
        System.out.println("Enter preparing time in seconds:");
        preparingTimeSec = Integer.parseInt(in.readLine());

        switch (answer) {
            case "1": 
                return new Coffee(title, coffeeMl, preparingTimeSec, waterMl);
            case "2":
                return new CoffeeDrink(title, coffeeMl, waterMl, warmMilkMl, milkFoamMl, preparingTimeSec);
        }
        throw new IllegalStateException("Unexpected value: " + answer);
    }

    void create(CoffeeRecipe newRecipe) throws IOException {
        recipes.add(newRecipe);
        DataManager.updateData(recipes);
    }

    void read() {

    }

    void update() throws IOException {
        recipes = DataManager.loadData();
    }

    int deleteMenu() throws IOException {
        showMenu();
        System.out.println("\n What coffee you prefer to delete?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String answer = in.readLine();
        return Integer.parseInt(answer) - 1;
    }

    void delete(int index) {
        recipes.remove(index);
    }
}
