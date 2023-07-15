package domain;

import java.util.Objects;

public class Count {

    private final long value;

    public Count(final long value) {
        validateNonNegative(value);
        this.value = value;
    }

    public boolean isZero() {
        return value == 0;
    }

    public boolean isLessThan(final Count other) {
        return value < other.value;
    }

    public boolean isNotEqualTo(final Count other) {
        return value != other.value;
    }

    public Count decreaseBy(final Count other) {
        return new Count(value - other.value);
    }

    public Count increaseByOne() {
        return new Count(value + 1);
    }

    public Count decreaseByOne() {
        return new Count(value - 1);
    }

    public long getValue() {
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
        final Count count = (Count) o;
        return value == count.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validateNonNegative(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("개수는 음수일 수 없습니다.");
        }
    }
}
