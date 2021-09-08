package step2.domain.lotto;

import step2.domain.statistics.Amount;

public class Price {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO_PRICE = 0;

    private final int price;

    public Price() {
        this(ZERO_PRICE);
    }

    public Price(int price) {

        if (price <= ZERO_PRICE) {
            throw new RuntimeException("구매 금액은 0 이하일 수 없습니다.");
        }
        this.price = price;
    }

    public Amount amount() {
        return new Amount(this.price / LOTTO_PRICE);
    }
}
