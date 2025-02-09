package main.java.cafe.controller;

import main.java.cafe.model.Beverage;
import main.java.cafe.model.BeverageManager;
import main.java.cafe.model.OrderDetatils;
import main.java.cafe.service.CafeService;
import main.java.cafe.util.TimerThread;
import main.java.cafe.view.InputView;
import main.java.cafe.view.OutputView;

public class CafeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CafeService cafeService;
    private final TimerThread timerThread;
    private final BeverageManager beverageManager;
    private static Beverage beverage;

    private final int nonCoffeeTypeIndex = 3; // noncoffee의 배열 인덱스에서 nonCoffeeTypeIndex 미만의 음료는 Ade, 이상은 Tea이다.

    public CafeController() {
        outputView = new OutputView();
        inputView = new InputView();
        cafeService = new CafeService();
        beverageManager = new BeverageManager();
        timerThread = new TimerThread(beverageManager);
    }

    public void run() {
        new Thread(timerThread).start();
        while (true) {
            orderMenu();
            if (printOrder().equals("Y")){
                beverageManager.addBeverage(beverage);
            }
        }
    }

    private void orderMenu() {
        OrderDetatils orderDetatils = getOrderDetatils();
        makeBeverage(orderDetatils);
    }

    private OrderDetatils getOrderDetatils() {
        String beverageType = inputView.getBeverageType();
        String beverageInfo = inputView.getBeverageInfo(beverageType);
        String isCaffeine = beverageType.equals("커피") ? inputView.getIsCaffeine() : "카페인";
        String beverageTemperature = inputView.getTemperature();
        String beverageSize = inputView.getSize();

        return new OrderDetatils(beverageType, beverageInfo, beverageTemperature, isCaffeine, beverageSize);
    }

    private void makeBeverage(OrderDetatils orderDetatils) {
        if (orderDetatils.getBeverageType().equals("커피")) {
            beverage = cafeService.makeCoffee(orderDetatils.getBeverageInfo(), orderDetatils.getBeverageSize(), orderDetatils.getBeverageTemperature(), orderDetatils.getIsCaffeine());
        } else {
            int numberOfBeverage = Character.getNumericValue(orderDetatils.getBeverageInfo().charAt(0));
            if (numberOfBeverage <= nonCoffeeTypeIndex) {
                String beverageSweetness = inputView.getSweetness();
                beverage = cafeService.makeAde(orderDetatils.getBeverageInfo(), orderDetatils.getBeverageSize(), orderDetatils.getBeverageTemperature(), beverageSweetness);
            } else {
                beverage = cafeService.makeTea(orderDetatils.getBeverageInfo(), orderDetatils.getBeverageSize(), orderDetatils.getBeverageTemperature());
            }
        }

    }

    private String printOrder() {
        return outputView.printOrder(beverage);
    }
}
