package com.company.Services;

import com.company.Coffee;
import com.company.CoffeeDrink;
import com.company.CoffeeRecipe;

import java.io.*;
import java.util.*;

public class DataManager {
    public static void updateData(List<CoffeeRecipe> recipes) throws IOException {
        LinkedList<List<String>> rows = new LinkedList<>(Arrays.asList());
        for (CoffeeRecipe recipe : recipes) {
            if (recipe instanceof CoffeeDrink) {
                rows.add(Arrays.asList(recipe.title,
                        Double.toString(recipe.coffeeMl),
                        Double.toString(recipe.preparingTimeSec),
                        Double.toString(recipe.waterMl),
                        Double.toString(((CoffeeDrink) recipe).warmMilkMl),
                        Double.toString(((CoffeeDrink) recipe).milkFoamMl)));
            } else {
                rows.add(Arrays.asList(recipe.title,
                        Double.toString(recipe.coffeeMl),
                        Double.toString(recipe.preparingTimeSec),
                        Double.toString(recipe.waterMl), "", ""));
            }
        }

        FileWriter csvWriter = new FileWriter("recipes.csv");
        csvWriter.append("Title");
        csvWriter.append(",");
        csvWriter.append("CoffeeMl");
        csvWriter.append(",");
        csvWriter.append("PreparingTimeSec");
        csvWriter.append(",");
        csvWriter.append("WaterMl");
        csvWriter.append(",");
        csvWriter.append("WarmMilkMl");
        csvWriter.append(",");
        csvWriter.append("MilkFoamMl");
        csvWriter.append("\n");

        for (List<String> rowData : rows) {
            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

    public static List<CoffeeRecipe> loadData() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("recipes.csv"));
        String row;
        List<CoffeeRecipe> loadedList = new ArrayList<CoffeeRecipe>();
        while ((row = csvReader.readLine()) != null) {
            loadedList.add(CSVDecoderService.parseString(row));
        }
        csvReader.close();
        return loadedList;
        }
    }
