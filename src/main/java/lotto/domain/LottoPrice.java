package lotto.domain;

import java.math.BigDecimal;

public class LottoPrice {

    public static final int LOTTO_PRICE = 1000;

    private final Money price;

    public LottoPrice() {
        this.price = new Money(LOTTO_PRICE);
    }
}
