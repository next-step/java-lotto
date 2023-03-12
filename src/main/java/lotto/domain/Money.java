package lotto.domain;

import java.math.BigDecimal;

public class Money {
    public static final Money ZERO = new Money(0);

    private BigDecimal wonValue;

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
}
