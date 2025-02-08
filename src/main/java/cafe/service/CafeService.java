package main.java.cafe.service;

import main.java.cafe.model.*;

public class CafeService {

    public Beverage makeCoffee(String info, String size, String temperature, String isCaffeine) {
        Beverage beverage = makeBeverage(info, size, temperature);

        return new Coffee(beverage.getName(), beverage.isHot(), beverage.getSize(), beverage.getPrice() + getCaffeinePrice(isCaffeine), isCaffeine.equals("카페인"));
    }

    public Beverage makeAde(String info, String size, String temperature, String sweetness) {
        Beverage beverage = makeBeverage(info, size, temperature);

        return new Ade(beverage.getName(), beverage.isHot(), beverage.getSize(), beverage.getPrice(), sweetness);
    }

    public Beverage makeTea(String info, String size, String temperature) {
        Beverage beverage = makeBeverage(info, size, temperature);

        return new Tea(beverage.getName(), beverage.isHot(), beverage.getSize(), beverage.getPrice());
    }

    private Beverage makeBeverage(String info, String size, String temperature) {
        char sizeChar = size.charAt(0);
        boolean isHot = temperature.equals("Hot");

        BeverageParser beverageParser = BeverageParser.parse(info);
        String nameOfBeverage = beverageParser.getName();
        int priceOfBeverage = beverageParser.getPrice() + getSizePrice(sizeChar);

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
