package lotto.domain;

import lotto.domain.statistics.RateOfReturn;

public class Cash {
    private final long value;

    public Cash(long cash) {
        assertCashPositive(cash);
        this.value = cash;
    }

    public long value() {
        return this.value;
    }

    public long buyableAmount(long price) {
        assertPriceGreaterThanZero(price);

        return value / price;
    }

    public RateOfReturn rateOfReturn(Cash earned) {
        return new RateOfReturn(((double) earned.value()) / value);
    }

    private void assertCashPositive(long cash) {
        if (cash < 0L) {
            throw new IllegalArgumentException("현금은 마이너스 통장이 아닙니다.");
        }
    }

    private void assertPriceGreaterThanZero(long price) {
        if (price <= 0L) {
            throw new IllegalArgumentException("양수인 가격만 지원합니다.");
        }
    }
}
