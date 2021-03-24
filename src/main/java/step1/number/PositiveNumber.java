package step1.number;

import step1.exception.InvalidNumberInputException;
import step1.exception.StringNumberFormatException;

import java.util.Objects;

public final class PositiveNumber {

    private final Integer positiveNumber;

    private static final int ZERO = 0;
    private static final int MAXIMUM = 128;

    private static final PositiveNumber[] cache;

    static {
        cache = new PositiveNumber[MAXIMUM];
    }

    public static final PositiveNumber valueOf(String positiveNumber) {
        return valueOf(convertStringToInt(positiveNumber));
    }

    public static final PositiveNumber valueOf(Integer positiveNumber) {
        if (isNegativeOrOutOfBounds(positiveNumber)) {
            throw new InvalidNumberInputException();
        }
        if (isCacheNull(positiveNumber)) {
            cache[positiveNumber] = new PositiveNumber(positiveNumber);
        }
        return cache[positiveNumber];
    }

    private PositiveNumber(Integer positiveNumber) {
        this.positiveNumber = Integer.valueOf(positiveNumber);
    }

    private static final boolean isCacheNull(Integer index) {
        return cache[index] == null;
    }

    private static final Integer convertStringToInt(String positiveNumber) {
        try {
            return Integer.valueOf(positiveNumber);
        } catch (Exception e) {
            throw new StringNumberFormatException();
        }
    }

    private static final boolean isNegativeOrOutOfBounds(Integer positiveNumber) {
        return (isNegative(positiveNumber) || isOutOfBounds(positiveNumber));
    }

    private static final boolean isNegative(Integer positiveNumber) {
        return positiveNumber < ZERO;
    }

    private static final boolean isOutOfBounds(Integer positiveNumber) {
        return positiveNumber >= MAXIMUM;
    }


    public final Integer getPositiveNumber() {
        return positiveNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber positiveNumber1 = (PositiveNumber) o;
        return positiveNumber == positiveNumber1.positiveNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumber);
    }
}
