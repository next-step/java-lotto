package lotto.domain;

public class Money {

    private static final String INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 금액입니다. amount: %s";
    private static final int MINIMUM_MONEY_AMOUNT = 0;

    private final long amount;

    private Money(long amount) {
        validateNonNegative(amount);
        this.amount = amount;
    }

    public static Money zero() {
        return new Money(MINIMUM_MONEY_AMOUNT);
    }

    private void validateNonNegative(long amount) {
        if (amount < MINIMUM_MONEY_AMOUNT) {
            throw new IllegalArgumentException(String.format(INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE_FORMAT, amount));
        }
    }

    public static Money of(long amount) {
        return new Money(amount);
    }

    public boolean isDivisibleBy(Money other) {
        return this.amount % other.amount == 0;
    }

    public double divide(Money other) {
        return (double) this.amount / other.amount;
    }

    public Money multiply(long number) {
        return Money.of(amount * number);
    }

    public Money add(Money other) {
        return Money.of(this.amount + other.amount);
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return (int) (amount ^ (amount >>> 32));
    }
}
