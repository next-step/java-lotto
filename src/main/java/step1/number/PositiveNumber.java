package step1.number;

import step1.exception.NegativeNumberInputException;
import step1.exception.StringNumberFormatException;

import java.util.Arrays;
import java.util.Objects;

public final class PositiveNumber {

    private final Integer positiveNumber;

    private static final int ZERO = 0;
    private static final int MAX_LENGTH = 128;

    private static final PositiveNumber[] cache;

    static {
        cache = new PositiveNumber[MAX_LENGTH];
    }

    public static final PositiveNumber valueOf(String positiveNumber) {
        return valueOf(convertStringToInt(positiveNumber));
    }

    public static final PositiveNumber valueOf(Integer positiveNumber) {
        if (isNegative(positiveNumber)) {
            throw new NegativeNumberInputException();
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

    private static final boolean isNegative(Integer positiveNumber) {
        return positiveNumber < ZERO;
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
