package lotto.domain;

import common.Pair;

public class Money implements Comparable<Money> {

    public static final Money ZERO = new Money(0);

    private int value;

    public Money(int value) {
        this.value = value;
        validate();
    }

    private void validate() {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    public Money add(Money money) {
        return new Money(value + money.value);
    }

    public Money sub(Money money) {
        return new Money(value - money.value);
    }

    public Money mul(Money money) {
        return new Money(value * money.value);
    }

    public Money div(Money money) {
        return new Money(value / money.value);
    }

    public Money mod(Money money) {
        return new Money(value % money.value);
    }

    public Pair<Money> divAndMod(Money money) {
        return new Pair<>(this.div(money), this.mod(money));
    }

    @Override
    public int compareTo(Money o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
