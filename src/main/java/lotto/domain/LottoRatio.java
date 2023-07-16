package lotto.domain;

import java.util.Objects;
import java.util.StringJoiner;

public final class LottoRatio {

    private final double value;

    public LottoRatio(final double value) {
        validateValueRange(value);
        this.value = value;
    }

    private void validateValueRange(final double value) {
        if (value < 0) {
            throw new IllegalArgumentException("수익률은 0보다 작을 수 없습니다.");
        }
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoRatio that = (LottoRatio) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LottoRatio.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
