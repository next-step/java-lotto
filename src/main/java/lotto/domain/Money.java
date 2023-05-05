package lotto.domain;

public class Money {

    private final long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        return new Money(amount);
    }

    public Money minus(Money amount) {
        return new Money(this.amount - amount.amount);
    }

    public boolean isGreaterThan(Money money) {

        return amount >= money.amount;
    }

    public long getAmount() {
        return amount;
    }
}

