package lotto.domain;

import java.util.Objects;

import static java.lang.String.format;

public class PositiveNumber implements Comparable<PositiveNumber> {
    private static final long MINIMUM_AMOUNT = 0;
    private static final int UNDER = -1;

    public static final PositiveNumber ZERO = new PositiveNumber(0);

    private final long value;


    public PositiveNumber(String value) {
        this(Long.parseLong(value));
    }

    public PositiveNumber(int value) {
        this((long) value);
    }

    public PositiveNumber(long value) {
        validate(value);

        this.value = value;
    }

    public PositiveNumber divide(PositiveNumber target) {
        return new PositiveNumber(value / target.toLong());
    }

    public PositiveNumber multiple(PositiveNumber target) {
        return new PositiveNumber(value * target.toLong());
    }

    public PositiveNumber plus(PositiveNumber target) {
        return new PositiveNumber(value + target.toLong());
    }

    public PositiveNumber minus(PositiveNumber target) {
        return new PositiveNumber(value - target.toLong());
    }

    public long toLong() {
        return value;
    }

    public int toInt() {
        return (int) value;
    }

    private void validate(long value) {
        if (value < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(format("숫자는 %d 미만은 안됩니다.", MINIMUM_AMOUNT));
        }
    }

    public boolean isUnder(PositiveNumber target) {
        return compareTo(target) == UNDER;
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

    @Override
    public int compareTo(PositiveNumber o) {
        return Long.compare(toLong(), o.toLong());
    }
}
