package lotto.model.domain;

import java.util.Objects;

public final class ProfitRate implements Comparable<ProfitRate> {

    private final double value;

    private ProfitRate(final double value) {
        validate(value);
        this.value = value;
    }

    private void validate(final double value) {
        if (value < 0.0) {
            throw new IllegalArgumentException("수익률은 음수가 될 수 없습니다. 현재 수익률: " + value);
        }
    }

    public static ProfitRate valueOf(final double value) {
        return new ProfitRate(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ProfitRate that = (ProfitRate) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(final ProfitRate o) {
        return Double.compare(value, o.value);
    }
}
