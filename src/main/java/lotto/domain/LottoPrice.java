package lotto.domain;

public class LottoPrice {
    private static final int PRICE_PER_LOTTO = 1000;
    private final int price;

    public LottoPrice(String price) {
        this(Integer.parseInt(price));
    }

    public LottoPrice(int price) {
        if (price <= PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("로또를 구매할 수 없는 가격입니다");
        }
        this.price = price;
    }

    public double getProfit(int prize) {
        return (double) prize / price;
    }

    public int count() {
        return this.price / PRICE_PER_LOTTO;
    }
}
