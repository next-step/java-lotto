package lotto.model.lotto;

import java.util.Objects;

public class Money {

    private static final long ZERO = 0;

    private static final Money ZERO_MONEY = new Money(ZERO);

    private final long value;

    public Money() {
        this(ZERO);
    }

    public Money(long value) {
        validate(value);
        this.value = value;
    }

    private void validate(long value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("돈은 음수일 수 없습니다");
        }
    }

    public Money add(Money money) {
        return new Money(this.value + money.value);
    }

    public Money multiply(int count) {
        return new Money(this.value * count);
    }

    public double divide(Money money) {
        if(money.isZero()) {
            throw new ArithmeticException("0으로 나눌 수 없습니다");
        }
        return (double) this.value / money.value;
    }

    private boolean isZero() {
        return this.equals(ZERO_MONEY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
