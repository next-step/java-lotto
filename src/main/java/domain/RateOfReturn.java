package domain;

import java.util.Objects;

public class RateOfReturn {

    private final double value;

    public RateOfReturn(final long profit, final long investment) {
        validateNonNegative(profit);
        validatePositive(investment);
        value = (double) profit / investment;
    }

    public double getValue() {
        return value;
    }

    private void validateNonNegative(final long profit) {
        if (profit <= 0) {
            throw new IllegalArgumentException("수익률 계산 시 수익은 음수일 수 없습니다.");
        }
    }

    private void validatePositive(final long investment) {
        if (investment <= 0) {
            throw new IllegalArgumentException("수익률 계산 시 투입금액은 양수여야 합니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RateOfReturn that = (RateOfReturn) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
