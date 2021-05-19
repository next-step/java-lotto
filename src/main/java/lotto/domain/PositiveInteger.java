package lotto.domain;

import java.util.Objects;

import static java.lang.String.format;

public class PositiveInteger {
    private static final int MINIMUM_AMOUNT = 0;

    private int value;

    public PositiveInteger(int value) {
        if (value < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(format("숫자는 %d원 미만은 안됩니다.", MINIMUM_AMOUNT));
        }

        this.value = value;
    }

    public PositiveInteger divide(PositiveInteger target) {
        return new PositiveInteger(value / target.value);
    }

    public PositiveInteger multiple(PositiveInteger target) {
        return new PositiveInteger(value * target.getValue());
    }

    public PositiveInteger plus(PositiveInteger target) {
        return new PositiveInteger(value + target.getValue());
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveInteger positiveInteger1 = (PositiveInteger) o;
        return value == positiveInteger1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
