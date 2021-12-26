package lotto.domain;

import java.math.BigDecimal;

public class Money {

    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money from(int value) {
        return from(Long.valueOf(value));
    }

    public static Money from(long value) {
        verify(value);
        return new Money(BigDecimal.valueOf(value));
    }

    public static void verify(long value) {
        if (BigDecimal.ZERO.compareTo(BigDecimal.valueOf(value)) > 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
    }

    public int divideBy(Money value) {
        return Integer.parseInt(amount.divide(value.amount).toString());
    }

    public BigDecimal ratio(Money value) {
        return amount.divide(value.amount);
    }

    public Money multiply(long value) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(value)));
    }

    public Money add(Money value) {
        return new Money(this.amount.add(value.amount));
    }

    @Override
    public String toString() {
        return amount.toPlainString() + "원";
    }
}
