package domain;

import java.util.Objects;

public class RateOfReturn {

    private final double value;

    public RateOfReturn(final long nominator, final long denominator) {
        validatePositive(denominator);
        value = (double) nominator / denominator;
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

    private void validatePositive(final long denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("분모는 양수여야 합니다.");
        }
    }
}
