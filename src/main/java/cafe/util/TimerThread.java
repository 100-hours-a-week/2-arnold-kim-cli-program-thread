package main.java.cafe.util;

import main.java.cafe.model.Beverage;
import main.java.cafe.model.BeverageManager;

import java.util.List;

public class TimerThread extends Thread {
    private BeverageManager beverageManager;
    private boolean isDisplayingStatus = false;

    public TimerThread(BeverageManager beverageManager) {
        this.beverageManager = beverageManager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                List<Beverage> beverages = beverageManager.getBeverages();

                if (beverages.isEmpty()) {
                    if (isDisplayingStatus) {
                        clearStatusSection();
                        isDisplayingStatus = false;
                    }
                } else {
                    if (!isDisplayingStatus) {
                        isDisplayingStatus = true;
                    }

                    displayStatus(beverages);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void displayStatus(List<Beverage> beverages) {
        System.out.print("\033[s");  // 현재 커서 위치 저장
        System.out.print("\033[H");  // 커서 맨 위로 이동 (상태 출력 위치)

        System.out.println("=== 주문상태 ===");
        for (Beverage beverage : beverages) {
            System.out.println("주문하신 " + beverage.getName() + "는 " + beverage.getRemainTime() + "초 남았습니다.");
        }
        System.out.println("==============");

        System.out.print("\033[u");  // 저장된 커서 위치로 복원 (사용자 입력 위치)
    }

    private void clearStatusSection() {
        System.out.print("\033[s");
        System.out.print("\033[H");
        System.out.println("\033[2J");
        System.out.print("\033[u");
    }
}
