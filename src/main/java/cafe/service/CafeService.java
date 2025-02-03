package main.java.cafe.service;

import main.java.cafe.model.*;

public class CafeService {
    private static final int nonCoffeeTypeIndex = 3;

    public Beverage makeCoffee(String info, String size, String temperature, String isCaffeine) {
        Beverage beverage = makeBeverage(info, size, temperature);
        boolean caffeine = isCaffeine.equals("카페인");
        Beverage coffee = new Coffee(beverage.getName(), beverage.isHot(), beverage.getSize(), beverage.getPrice(), caffeine);
        coffee.increasePrice(getCaffeinePrice(isCaffeine));

        return coffee;
    }

    public Beverage makeNonCoffee(String info, String size, String temperature) {
        int numberOfBeverage = Character.getNumericValue(info.charAt(0));
        Beverage beverage = makeBeverage(info, size, temperature);

        if (numberOfBeverage < nonCoffeeTypeIndex) {
            return new Ade(beverage.getName(), beverage.isHot(), beverage.getSize(), beverage.getPrice());
        } else {
            return new Tea(beverage.getName(), beverage.isHot(), beverage.getSize(), beverage.getPrice());
        }
    }

    private Beverage makeBeverage(String info, String size, String temperature) {
        String[] infoList = info.split(" ");
        char sizeChar = size.charAt(0);

        String nameOfBeverage = infoList[1];
        int priceOfBeverage = Integer.parseInt(infoList[2].substring(0, infoList[2].length() - 1))
                + getSizePrice(sizeChar);

        boolean isHot = temperature.equals("Hot");

        return new Beverage(nameOfBeverage, isHot, sizeChar, priceOfBeverage);
    }

    private int getSizePrice(char sizeChar) {
        if (sizeChar == 'M') {
            return 500;
        } else if (sizeChar == 'L') {
            return 1000;
        }
        return 0;
    }

    private int getCaffeinePrice(String isCaffeine) {
        if (isCaffeine.equals("디카페인")) {
            return 500;
        }
        return 0;
    }
}
