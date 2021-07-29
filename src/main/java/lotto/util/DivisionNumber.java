package lotto.util;

import java.util.Objects;

public class DivisionNumber extends Number {
    private final Number leftNumber;
    private final Number rightNumber;

    public DivisionNumber(Number leftNumber, Number rightNumber) {
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }

    @Override
    public int intValue() {
        return leftNumber.intValue() / rightNumber.intValue();
    }

    @Override
    public long longValue() {
        return leftNumber.longValue() / rightNumber.longValue();
    }

    @Override
    public float floatValue() {
        return leftNumber.floatValue() / rightNumber.floatValue();
    }

    @Override
    public double doubleValue() {
        return floatValue();
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        DivisionNumber that = (DivisionNumber) compareValue;
        return intValue() == that.intValue() && floatValue() == that.floatValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(intValue(), floatValue());
    }
}
