package lotto.domain;

import java.util.Objects;

import static java.lang.String.format;

public class PositiveNumber {
    private static final long MINIMUM_AMOUNT = 0;

    public static final PositiveNumber ZERO = new PositiveNumber(0);

    private final long value;

    public PositiveNumber(int value) {
        this((long) value);
    }

    public PositiveNumber(long value) {
        validate(value);

        this.value = value;
    }

    public PositiveNumber divide(PositiveNumber target) {
        return new PositiveNumber(value / target.value);
    }

    public PositiveNumber multiple(PositiveNumber target) {
        return new PositiveNumber(value * target.getValue());
    }

    public PositiveNumber plus(PositiveNumber target) {
        return new PositiveNumber(value + target.getValue());
    }

    public long getValue() {
        return value;
    }

    private void validate(long value) {
        if (value < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(format("숫자는 %d원 미만은 안됩니다.", MINIMUM_AMOUNT));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber positiveNumber1 = (PositiveNumber) o;
        return value == positiveNumber1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
