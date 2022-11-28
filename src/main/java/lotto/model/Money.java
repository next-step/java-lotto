package lotto.model;

public class Money {
    private final int price;

    public Money(int price) {
        this.price = price;
    }

    public int total(int value) {
        return this.price * value;
    }

    public int getPrice() {
        return price;
    }
}
