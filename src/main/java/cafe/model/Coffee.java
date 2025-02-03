package main.java.cafe.model;

public class Coffee extends Beverage{

    private boolean isCaffeine;

    public Coffee(String name, boolean isHot, char size, int price, boolean isCaffeine) {
        super(name, isHot, size, price);
        this.isCaffeine = isCaffeine;
    }
}
