package top.yclu.boot.config.enums;

public enum DrinkType {
    COFFEE("咖啡", 30),TEA("奶茶", 20),JUICE("果汁",25 );
    private final String description;
    private final float price;
    DrinkType(String description, float price) {
        this.description = description;
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public float getPrice() {
        return price;
    }
}
