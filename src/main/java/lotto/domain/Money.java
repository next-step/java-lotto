package lotto.domain;

public class Money {
    private final long amount;

    public Money(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 0원 이상 이어야 합니다");
        }
        this.amount = amount;
    }

    public Money add(Money money) {
        return money.add(this.amount);
    }

    public Money add(long amount) {
        return new Money(this.amount + amount);
    }

    public Money multiply(int factor) {
        return new Money(this.amount * factor);
    }

    public double divide(Money other) {
        return (double) this.amount / other.getLong();
    }

    public boolean isLessThan(Money other) {
        return this.amount < other.getLong();
    }

    public boolean isMultipleOf(Money other) {
        return this.amount % other.getLong() == 0;
    }

    public long getLong() {
        return this.amount;
    }

    @Override
    public boolean equals(Object other) {
        return this.amount == ((Money) other).getLong();
    }
}
