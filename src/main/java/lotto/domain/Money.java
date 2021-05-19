package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final Money NONE = from(0);
    private static final int MINIMUN_OF_MONEY = 0;
    private static final int SECOND_DECIMAL_PLACES = 2;
    private static final String NEGATIVE_EXCEPTION_MESSAGE = "입력금액은 음수가 될 수 없습니다.";

    private final BigDecimal money;

    public Money(BigDecimal money) {
        validateNegative(money);
        this.money = money;
    }

    private void validateNegative(BigDecimal money) {
        if (money.compareTo(BigDecimal.ZERO) < MINIMUN_OF_MONEY) {
            throw new IllegalArgumentException(NEGATIVE_EXCEPTION_MESSAGE);
        }
    }

    public static Money from(long price) {
        return new Money(BigDecimal.valueOf(price));
    }

    public Money divide(Money price) {
        return new Money(money.divide(price.money, SECOND_DECIMAL_PLACES, BigDecimal.ROUND_FLOOR));
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

    public long longValue() {
        return money.longValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Objects.equals(money, money1.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
