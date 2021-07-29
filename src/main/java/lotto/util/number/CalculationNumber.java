package lotto.util.number;

import java.util.Objects;

public abstract class CalculationNumber extends Number {
    protected final Number leftNumber;
    protected final Number rightNumber;

    protected CalculationNumber(Number leftNumber, Number rightNumber) {
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }

    @Override
    public final boolean equals(Object compareValue) {
        if (!(compareValue instanceof Number))
            return false;
        Number that = (Number) compareValue;
        return (Objects.equals(intValue(), that.intValue()) && Objects.equals(longValue(), that.longValue())) || // 정수
                (Objects.equals(doubleValue(), that.doubleValue()) && Objects.equals(floatValue(), that.floatValue())); // 소수
    }

    @Override
    public final int hashCode() {
        return Objects.hash(intValue(), longValue(), doubleValue(), floatValue());
    }
}
