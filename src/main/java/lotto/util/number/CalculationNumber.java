package lotto.util.number;

import java.util.Objects;

public abstract class CalculationNumber extends Number {
    private final Number leftNumber;
    private final Number rightNumber;

    private Integer integerCache = null;
    private Long longCache = null;
    private Float floatCache = null;
    private Double doubleCache = null;

    protected CalculationNumber(Number leftNumber, Number rightNumber) {
        this.leftNumber = leftNumber;
        this.rightNumber = rightNumber;
    }

    @Override
    public final int intValue() {
        if (Objects.isNull(integerCache))
            integerCache = calculateInteger(leftNumber, rightNumber);
        return integerCache;
    }

    @Override
    public final long longValue() {
        if (Objects.isNull(longCache))
            longCache = calculateLong(leftNumber, rightNumber);
        return longCache;
    }

    @Override
    public final float floatValue() {
        if (Objects.isNull(floatCache))
            floatCache = calculateFloat(leftNumber, rightNumber);
        return floatCache;
    }

    @Override
    public final double doubleValue() {
        if (Objects.isNull(doubleCache))
            doubleCache = calculateDouble(leftNumber, rightNumber);
        return doubleCache;
    }

    protected abstract Integer calculateInteger(Number leftNumber, Number rightNumber);

    protected abstract Long calculateLong(Number leftNumber, Number rightNumber);

    protected abstract Float calculateFloat(Number leftNumber, Number rightNumber);

    protected abstract Double calculateDouble(Number leftNumber, Number rightNumber);

    public boolean isPositive() {
        return intValue() > 0 || longValue() > 0 || doubleValue() > 0 || floatValue() > 0;
    }

    public boolean isNegative() {
        return intValue() < 0 || longValue() < 0 || doubleValue() < 0 || floatValue() < 0;
    }

    @Override
    public final boolean equals(Object compareValue) {
        if (!(compareValue instanceof Number)) {
            return false;
        }
        Number that = (Number) compareValue;
        if (intValue() > 0 || longValue() > 0) {
            return Objects.equals(intValue(), that.intValue()) && Objects.equals(longValue(), that.longValue());
        }
        if (doubleValue() > 0 || floatValue() > 0) {
            return Objects.equals(doubleValue(), that.doubleValue()) && Objects.equals(floatValue(), that.floatValue());
        }
        return Objects.equals(intValue(), that.intValue()) && Objects.equals(longValue(), that.longValue()) &&
                Objects.equals(doubleValue(), that.doubleValue()) && Objects.equals(floatValue(), that.floatValue());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(intValue(), longValue(), doubleValue(), floatValue());
    }
}
