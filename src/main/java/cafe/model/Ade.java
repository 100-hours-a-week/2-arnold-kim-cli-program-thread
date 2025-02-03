package main.java.cafe.model;

public class Ade extends NonCoffee {

    private String sweetness;

    public Ade(String name, boolean isHot, char size, int price) {
        super(name, isHot, size, price);
        this.sweetness = "100%";
    }

    public Ade(String name, boolean isHot, char size, int price, String sweetness) {
        super(name, isHot, size, price);
        this.sweetness = sweetness;
    }
}
