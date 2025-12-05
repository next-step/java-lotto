package lotto.domain;

public class LottoPrice {
    private static final int PRICE_PER_LOTTO = 1000;
    private int price;

    public LottoPrice(int price) {
        this.price = price;
    }

    public int count() {
        return this.price / PRICE_PER_LOTTO;
    }
}
