package step2.domain.lotto;

import step2.domain.statistics.Amount;

public class Price {
    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public Price() {
        this(0);
    }

    public Price(int price) {
        if (price <= 0) {
            throw new RuntimeException("구매 금액은 0 이하일 수 없습니다.");
        }
        this.price = price;
    }

    public Amount amount() {
        return new Amount(this.price / LOTTO_PRICE);
    }
}
