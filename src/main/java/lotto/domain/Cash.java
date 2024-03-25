package lotto.domain;

import lotto.domain.statistics.RateOfReturn;

import java.math.BigDecimal;
import java.math.MathContext;

public class Cash {
    private final BigDecimal value;

    public Cash(long cash) {
        this(new BigDecimal(cash));
    }

    public Cash(BigDecimal cash) {
        assertCashPositive(cash);
        this.value = cash;
    }

    public BigDecimal value() {
        return this.value;
    }

    public int buyableAmount(Cash price) {
        assertPriceGreaterThanZero(price);

        return value.divideToIntegralValue(price.value())
                .intValue();
    }

    public RateOfReturn rateOfReturn(Cash earned) {
        return new RateOfReturn(earned.value().divide(value, MathContext.DECIMAL32).doubleValue());
    }

    public boolean equalsZero() {
        return value.equals(BigDecimal.ZERO);
    }

    private void assertCashPositive(BigDecimal cash) {
        if (cash.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("현금은 마이너스 통장이 아닙니다.");
        }
    }

    private void assertPriceGreaterThanZero(Cash price) {
        if (price.equalsZero()) {
            throw new IllegalArgumentException("공짜는 없는 세상입니다.");
        }
    }
}
