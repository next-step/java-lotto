package lotto.domain;

public class Price {

    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public Price(int price) {
        this.price = price;
    }

    public LottoCounts lottoCountsCalculator() {
        return new LottoCounts(price / LOTTO_PRICE);
    }

    public int getPrice() {
        return price;
    }
}
