package me.namuhuchutong.lotto.domain;


import java.util.Objects;

public class Number {

    private static final int MINIMUM_CONDITION = 1;
    private static final int MAXIMUM_CONDITION = 45;

    private final Integer values;

    public Number(Integer values) {
        validateNumbersRange(values);
        this.values = values;
    }

    private void validateNumbersRange(Integer values) {
        if (MINIMUM_CONDITION > values || values > MAXIMUM_CONDITION) {
            throw new IllegalArgumentException("숫자는 1~45 사이만 가능합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return values.equals(number.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
