package model.lotto;

public class Price {
    private static final int MIN_PRICE = 1;
    private final int price;

    public Price(int price) {
        checkValidPrice(price);
        this.price = price;
    }

    private void checkValidPrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public int getPrice() {
        return this.price;
    }

    public double getPercentOf(int value) {
        return (double) value / this.price;
    }
}
