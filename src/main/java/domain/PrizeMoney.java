package domain;

public enum PrizeMoney {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000);

    private int price;

    PrizeMoney(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
