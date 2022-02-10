package lotto.domain;

public class Price {

    private final int price;

    private Price(int price) {
        this.price = price;
    }

    public static Price from(int price) {
        return new Price(price);
    }

    public int getValue() {
        return price;
    }
}
