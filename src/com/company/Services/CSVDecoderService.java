package com.company.Services;

import com.company.Coffee;
import com.company.CoffeeDrink;
import com.company.CoffeeRecipe;

public class CSVDecoderService {
    public static CoffeeRecipe parseString(String input) {
        String[] fields = input.split(",");
        switch (fields.length) {
            case 4:
                return new Coffee(fields[0],
                        Double.parseDouble(fields[1]),
                        Integer.parseInt(fields[2]),
                        Double.parseDouble(fields[3]));
            case 6:
                return new CoffeeDrink(fields[0],
                        Double.parseDouble(fields[1]),
                        Double.parseDouble(fields[5]),
                        Double.parseDouble(fields[3]),
                        Double.parseDouble(fields[4]),
                        Integer.parseInt(fields[2]));
            default: return null;
        }
    }
}
