package lotto.domain;

import java.math.BigDecimal;

public class Money {

    private final BigDecimal money;

    public Money(BigDecimal money) {
        this.money = money;
    }

    public static Money from(long price) {
        return new Money(BigDecimal.valueOf(price));
    }

    public int divide(long price) {
        return money.divide(BigDecimal.valueOf(price))
                    .intValue();
    }
}
