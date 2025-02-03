package main.java.cafe.controller;

import main.java.cafe.model.Beverage;
import main.java.cafe.service.CafeService;
import main.java.cafe.view.InputView;
import main.java.cafe.view.OutputView;

public class CafeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CafeService cafeService;
    private static Beverage beverage;

    private final int nonCoffeeTypeIndex = 3; // noncoffee의 배열 인덱스에서 nonCoffeeTypeIndex 미만의 음료는 Ade, 이상은 Tea이다.

    public CafeController() {
        outputView = new OutputView();
        inputView = new InputView();
        cafeService = new CafeService();
    }

    public void run() {
        orderMenu();
        printOrder();
    }

    private void orderMenu() {
        String beverageType = inputView.getBeverageType();
        String beverageInfo = inputView.getBeverageInfo(beverageType);
        String isCaffeine = "카페인";
        if (beverageType.equals("커피")) {
            isCaffeine = inputView.getIsCaffeine();
        }
        String beverageTemperature = inputView.getTemperature();
        String beverageSize = inputView.getSize();

        if (beverageType.equals("커피")) {
            beverage = cafeService.makeCoffee(beverageInfo, beverageSize, beverageTemperature, isCaffeine);
        } else {
            int numberOfBeverage = Character.getNumericValue(beverageInfo.charAt(0));
            if (numberOfBeverage < nonCoffeeTypeIndex) {
                String beverageSweetness = inputView.getSweetness();
                beverage = cafeService.makeAde(beverageInfo, beverageSize, beverageTemperature, beverageSweetness);
            } else {
                beverage = cafeService.makeTea(beverageInfo, beverageSize, beverageTemperature);
            }
        }
    }

    private void printOrder() {
        outputView.printOrder(beverage);
    }
}
