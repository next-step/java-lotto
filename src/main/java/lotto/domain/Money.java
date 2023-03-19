package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final Money ZERO = new Money(0);

    private final BigDecimal wonValue;

    public Money(int wonValue) {
        this(BigDecimal.valueOf(wonValue));
    }

    public Money(BigDecimal wonValue) {
        this.wonValue = wonValue;
    }

    public Money multiply(int multiplyNumber) {
        return new Money(wonValue.multiply(BigDecimal.valueOf(multiplyNumber)));
    }

    public Money division(Money divisionNumber) {
        return new Money(this.wonValue.divide(divisionNumber.wonValue));
    }

    public Integer toInteger() {
        return wonValue.intValue();
    }

    @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(wonValue, money.wonValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wonValue);
    }
}
