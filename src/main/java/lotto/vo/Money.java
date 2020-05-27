package lotto.vo;

public class Money {
    private long value;

    public Money(long value) {
        this.value = value;
    }

    public Money spend(Money money) {
        return new Money(this.value - money.value);
    }

    public boolean isEnoughToBuy(Money price) {
        return this.value >= price.value;
    }

    public Money sum(Money money) {
        if (money.value == 0) {
            return this;
        }
        return new Money(this.value + money.value);
    }

    public long getValue() {
        return value;
    }
}
