package step2.domain;

public class Price {
    private static final int PURCHASE_MIN_PRICE = 1000;

    private int price;

    private Price() {
    }

    public Price(int price) {
        validatePurchasePrice(price);
        this.price = price;
    }

    public static Price of(int price) {
        return new Price(price);
    }

    public float revenueOf(int targetPrice) {
        return (targetPrice / (float) price);
    }

    public int getPrice() {
        return price;
    }

    private void validatePurchasePrice(int price) {
        if (price < PURCHASE_MIN_PRICE) {
            throw new IllegalArgumentException("로또 구입 최소 금액은 1000원 입니다.");
        }
    }
}
