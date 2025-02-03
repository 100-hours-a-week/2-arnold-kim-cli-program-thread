package main.java.cafe;

import main.java.cafe.controller.CafeController;

public class Application {
    public static void main(String[] args) {
        final CafeController cafeController = new CafeController();

        cafeController.run();

    }
}
