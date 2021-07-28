package lotto.util;

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
        return leftNumber.doubleValue() / rightNumber.doubleValue();
    }
}
