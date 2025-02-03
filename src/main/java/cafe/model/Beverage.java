package main.java.cafe.model;

public class Beverage {

    private String name;
    private boolean isHot;
    private char size;
    private int price;

    public Beverage(String name, boolean isHot, char size, int price) {
        this.name = name;
        this.isHot = isHot;
        this.size = size;
        this.price = price;
    }

    public void increasePrice(int amount) {
        this.price += amount;
    }

    public String getName() {
        return name;
    }

    public boolean isHot() {
        return isHot;
    }

    public char getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}
;