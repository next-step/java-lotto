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

    public double division(Money money) {
        return (double) this.amount / money.amount;
    }

    public boolean isGreaterThanZero() {
        return amount > 0;
    }

}

