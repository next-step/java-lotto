package lotto.vo;

public class Money {
    private final long value;

    public Money(final long value) {
        this.value = value;
    }

    public static Money of(final long value) {
        return new Money(value);
    }

    public Money spend(final Money money) {
        return new Money(this.value - money.value);
    }

    public Money add(final Money money) {
        if (money.value == 0) {
            return this;
        }
        return new Money(this.value + money.value);
    }

    public double calculateYield(Money expenditure) {
        return (double) this.value / expenditure.value;
    }

    public boolean isEnoughToBuy(final Money price) {
        return this.value >= price.value;
    }

    public long getValue() {
        return value;
    }
}
