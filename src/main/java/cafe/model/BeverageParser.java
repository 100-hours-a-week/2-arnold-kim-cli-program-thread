package main.java.cafe.model;

public class BeverageParser {

    private String name;
    private int price;

    public BeverageParser(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static BeverageParser parse(String info) {
        String[] infoList = info.split(" ");
        String name = infoList[1];
        int price = Integer.parseInt(infoList[2].substring(0, infoList[2].length() - 1));

        return new BeverageParser(name, price);
    }
}
