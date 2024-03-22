package domain.lotto;

import domain.common.Money;

public class LottoPrice {
    private final static Money LOTTO_PRICE = new Money(1000L);

    private LottoPrice(long l) {
    }

    public static long availableForPurchase(Money money) {
        return LOTTO_PRICE.divide(money);
    }
}
