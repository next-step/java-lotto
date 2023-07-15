package domain;

import java.util.Objects;

public class LottoCount {

    private final long value;

    public LottoCount(final long value) {
        validateNonNegative(value);
        this.value = value;
    }

    public boolean isZero() {
        return value == 0;
    }

    public boolean isLessThan(final LottoCount other) {
        return value < other.value;
    }

    public LottoCount decreaseBy(final LottoCount other) {
        return new LottoCount(value - other.value);
    }

    public long getValue() {
        return value;
    }

    private void validateNonNegative(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("개수는 음수일 수 없습니다.");
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
        final LottoCount lottoCount = (LottoCount) o;
        return value == lottoCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
