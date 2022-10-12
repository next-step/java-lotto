package lotto.domain;

public class Price {
    private static final int MIN_PRICE = 1000;

    private final int price;

    public Price(int price) {
        if (price < MIN_PRICE || price % MIN_PRICE != 0) {
            throw new RuntimeException("1000원 단위로 가능합니다.");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
