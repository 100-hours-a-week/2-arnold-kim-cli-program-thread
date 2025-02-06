package main.java.cafe.model;

public class OrderDetatils {
    private String beverageType;
    private String beverageInfo;
    private String isCaffeine;
    private String beverageTemperature;
    private String beverageSize;

    public OrderDetatils(String beverageType, String beverageInfo, String isCaffeine, String beverageTemperature, String beverageSize) {
        this.beverageType = beverageType;
        this.beverageInfo = beverageInfo;
        this.isCaffeine = isCaffeine;
        this.beverageTemperature = beverageTemperature;
        this.beverageSize = beverageSize;
    }

    public String getBeverageType() {
        return beverageType;
    }

    public String getBeverageInfo() {
        return beverageInfo;
    }

    public String getIsCaffeine() {
        return isCaffeine;
    }

    public String getBeverageTemperature() {
        return beverageTemperature;
    }

    public String getBeverageSize() {
        return beverageSize;
    }
}
