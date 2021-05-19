package lotto.domain;

import java.math.BigDecimal;

public class Money {

    public static final Money NONE = from(0);
    private final BigDecimal money;

    public Money(BigDecimal money) {
        this.money = money;
    }

    public static Money from(long price) {
        return new Money(BigDecimal.valueOf(price));
    }

    public Money divide(Money price) {
        return new Money(money.divide(price.money, 2, BigDecimal.ROUND_FLOOR));
    }

    public Money sum(Money input) {
        return new Money(money.add(input.money));
    }

    public int intValue() {
        return money.intValue();
    }

    public double doubleValue() {
        return money.doubleValue();
    }
}
