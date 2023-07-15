package domain;

import java.util.Objects;

public class RateOfReturn {

    private final double value;

    public RateOfReturn(final long profit, final long investment) {
        validatePositive(investment);
        value = (double) profit / investment;
    }

    public RateOfReturn(final double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
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

    private void validatePositive(final long investment) {
        if (investment <= 0) {
            throw new IllegalArgumentException("수익률 계산 시 투입금액은 양수여야 합니다.");
        }
    }
}
