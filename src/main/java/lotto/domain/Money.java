package lotto.domain;

public class Money {

    private static final String INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 금액입니다. amount: %s";

    private final long amount;

    private Money(long amount) {
        validateNonNegative(amount);
        this.amount = amount;
    }

    private void validateNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(String.format(INVALID_MONEY_AMOUNT_EXCEPTION_MESSAGE_FORMAT, amount));
        }
    }

    public static Money of(long amount) {
        return new Money(amount);
    }

    public boolean isDivisibleBy(Money other) {
        return this.amount % other.amount == 0;
    }

    public long divide(Money other) {
        return this.amount / other.amount;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("Money{amount=%s}", amount);
    }
}
