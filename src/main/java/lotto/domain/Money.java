package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Money {

    public static final Money ZERO = Money.wons(0);
    public static final Money ONE = Money.wons(1);

    private static final int DECIMAL_POINT_SIZE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

    private final BigDecimal amount;

    private Money(final BigDecimal amount) {
        validateAmount(amount);
        this.amount = amount.stripTrailingZeros();
    }

    private static void validateAmount(final BigDecimal amount) {
        if (isLessThanZero(amount)) {
            throw new LottoException("amount can not be negative");
        }
    }

    private static boolean isLessThanZero(final BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) < 0;
    }

    public static Money wons(final long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(final double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(final Money other) {
        return new Money(amount.add(other.amount));
    }

    public Money minus(final Money other) {
        return new Money(amount.subtract(other.amount));
    }

    public Money divide(final Money other) {
        try {
            return new Money(amount.divide(other.amount, DECIMAL_POINT_SIZE, ROUNDING_MODE));
        } catch (final ArithmeticException arithmeticException) {
            return Money.ZERO;
        }
    }

    public Money multiply(final Money other) {
        return new Money(amount.multiply(other.amount));
    }

    public Money multiply(final long percent) {
        return new Money(amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(final Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(final Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    public Double doubleValue() {
        return amount.doubleValue();
    }

    public int intValue() {
        return amount.intValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
            "amount=" + amount +
            '}';
    }
}
