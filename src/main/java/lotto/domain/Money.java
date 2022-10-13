package lotto.domain;

import lotto.domain.exception.NotNumberStringException;
import lotto.domain.exception.NotZeroOrMoreNumberException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class Money {

    private final BigInteger value;

    public Money(final BigInteger value) {
        NullCheckUtil.validate(value);
        validateZeroOrMore(value);
        this.value = value;
    }

    public Money(final int value) {
        this(BigInteger.valueOf(value));
    }

    public Money(final String stringValue) {
        this(parseBigInteger(stringValue));
    }

    private void validateZeroOrMore(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0) {
            throw NotZeroOrMoreNumberException.getInstance();
        }
    }

    private static BigInteger parseBigInteger(String stringValue) {
        try {
            return new BigInteger(stringValue);
        } catch (NumberFormatException e) {
            throw NotNumberStringException.getInstance();
        }
    }

    public boolean equalOrMoreThan(Money money) {
        return value.compareTo(money.value) > -1;
    }

    public static Money sumMoney(List<Money> moneys) {
        BigInteger total = moneys.stream()
                .map(m -> m.value)
                .reduce(BigInteger.ZERO, BigInteger::add);
        return new Money(total);
    }

    public Money subtract(Money subtrahend) {
        BigInteger minuend = value.subtract(subtrahend.value);
        return new Money(minuend);
    }

    public Money multiply(BigInteger multiplicand) {
        BigInteger multiplier = value.multiply(multiplicand);
        return new Money(multiplier);
    }

    public BigDecimal divide(Money divisor) {
        BigDecimal decimalValue = new BigDecimal(value);
        BigDecimal decimalDivisor = new BigDecimal(divisor.value);
        return decimalValue.divide(decimalDivisor, 2, RoundingMode.DOWN);
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

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
