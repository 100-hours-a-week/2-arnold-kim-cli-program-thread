package main.java.cafe.view;

import java.util.Scanner;

public class InputView {
    private static final String COFFEE = "커피";
    private static final String NONCOFFEE = "논커피";
    private static final String CAFFEINE = "카페인";
    private static final String DECAFFEINE = "디카페인";
    private static final String HOT = "HOT";
    private static final String ICED = "ICED";
    
    
    private final String[] coffeeMenu = {"1. 아메리카노 2900원", "2. 카페라떼 4500원", "3. 카페모카 4800원", "4. 헤이즐넛아메리카노 3300원", "5. 아인슈페너 4900원"};
    private final String[] nonCoffeeMenu = {"1. 애플망고에이드 4800원", "2. 레몬에이드 4800원", "3. 자몽에이드 4800원", "4. 복숭아아이스티 4300원", "5. 캐모마일 4500원"};

    public String getBeverageType(){
        System.out.println("커피 / 논커피");
        while (true) {
            String userInput = getUserInput("음료의 종류를 골라주세요. ");
            System.out.println();
            if (!userInput.equals(COFFEE) && !userInput.equals(NONCOFFEE)) {
                System.out.println("커피, 논커피 중 골라주세요.");
                continue;
            }
            return userInput;
        }

    }

    public String getBeverageInfo(String beverageType) {
        while (true) {
            try {
                if (beverageType.equals(COFFEE)) {
                    for (String beverageInfo : coffeeMenu) {
                        System.out.println(beverageInfo);
                    }
                } else {
                    for (String beverageInfo : nonCoffeeMenu) {
                        System.out.println(beverageInfo);
                    }
                }
                String userInput = getUserInput("메뉴를 번호로 입력해주세요. ");
                System.out.println();
                if (beverageType.equals(COFFEE)) {
                    return coffeeMenu[Integer.parseInt(userInput) - 1];
                } else {
                    return nonCoffeeMenu[Integer.parseInt(userInput) - 1];
                }
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("제시된 메뉴의 숫자만 입력해주세요");
            }
        }
    }

    public String getTemperature() {
        while (true) {
            System.out.println("Hot");
            System.out.println("Iced");

            String userInput = getUserInput("따뜻한 음료와 차가운 음료 중에서 골라주세요. ").toUpperCase();
            System.out.println();
            if (!userInput.equals(HOT) && !userInput.equals(ICED)) {
                System.out.println("Hot 또는 Iced 중에서 선택해주세요.");
                continue;
            }
            return userInput;
        }
    }

    public String getIsCaffeine() {
        while (true) {
            System.out.println(CAFFEINE);
            System.out.println("디카페인 ... +500원");

            String userInput = getUserInput("카페인과 디카페인 중에서 골라주세요. ");
            System.out.println();
            if (!userInput.equals(CAFFEINE) && !userInput.equals(DECAFFEINE)) {
                System.out.println("카페인 또는 디카페인 중에서 선택해주세요.");
                continue;
            }
            return userInput;
        }
    }

    public String getSize() {
        while (true) {
            System.out.println("S");
            System.out.println("M ... +500원");
            System.out.println("L ... +1000원");

            String userInput = getUserInput("사이즈를 선택해주세요. ").toUpperCase();
            System.out.println();
            if (!userInput.equals("S") && !userInput.equals("M") && !userInput.equals("L")) {
                System.out.println("S, M, L 중에서 골라주세요.");
                continue;
            }
            return userInput;
        }
    }
    public String getSweetness() {
        while (true) {
            System.out.println("25%");
            System.out.println("50%");
            System.out.println("75%");
            System.out.println("100%");
            String userInput = getUserInput("당도를 선택해주세요. ");
            System.out.println();
            if (!userInput.equals("25%") && !userInput.equals("50%") && !userInput.equals("75%") && !userInput.equals("100%")) {
                System.out.println("25%, 50%, 75%, 100% 중에서 골라주세요.");
                continue;
            }
            return userInput;
        }
    }

    private String getUserInput(String consoleMessage) {
        String userInput = "";
        Scanner sc = new Scanner(System.in);
        while (userInput.isEmpty()) {
            System.out.println(consoleMessage);
            System.out.print(">> ");
            userInput = sc.nextLine().strip();
        }
        if (userInput.equals("exit")) { System.exit(0); }
        return userInput;
    }
}
