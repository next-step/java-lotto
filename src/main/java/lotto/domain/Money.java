package lotto.domain;

import java.math.BigInteger;
import java.util.Objects;

public class Money {

    private final BigInteger value;

    public Money(final BigInteger value) {
        validateZeroOrMore(value);
        this.value = value;
    }

    public Money(final String stringValue) {
        this(parseBigInteger(stringValue));
    }

    private void validateZeroOrMore(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw NotZeroOrMoreNumberException.of();
        }
    }

    private static BigInteger parseBigInteger(String stringValue) {
        try {
            return new BigInteger(stringValue);
        } catch (NumberFormatException e) {
            throw NotNumberStringException.of();
        }
    }

    public boolean isThousandUnits() {
        return !isZeroValue() && isMultiplesThousand();
    }

    private boolean isZeroValue() {
        return value.compareTo(BigInteger.ZERO) == 0;
    }

    private boolean isMultiplesThousand() {
        BigInteger remainder = value.remainder(BigInteger.valueOf(1000));
        return remainder.compareTo(BigInteger.ZERO) == 0;
    }

    public BigInteger divideBy(BigInteger unit) {
        return value.divide(unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
