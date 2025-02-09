package main.java.cafe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeverageManager {
    private final List<Beverage> beverages = Collections.synchronizedList(new ArrayList<>());

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage);
        startTimer(beverage);
    }

    private void startTimer(Beverage beverage) {
        new Thread(() -> {
            while (beverage.getRemainTime() > 0) {
                try {
                    Thread.sleep(1000);
                    beverage.decreaseRemainTime(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            beverages.remove(beverage);

            System.out.println("주문하신 " + beverage.getName() + " 나왔습니다.");
        }).start();
    }

    public List<Beverage> getBeverages() {
        return new ArrayList<>(beverages);
    }
}
