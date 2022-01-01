package lotto.domain;

import java.math.BigDecimal;

public class Money {

    private final BigDecimal amount;

    private Money(long amount) {
        this(BigDecimal.valueOf(amount));
    }

    private Money(BigDecimal amount) {
        verify(amount);
        this.amount = amount;
    }

    public static Money from(long value) {
        return new Money(value);
    }

    public static void verify(BigDecimal amount) {
        if (BigDecimal.ZERO.compareTo(amount) > 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int divideBy(Money value) {
        return amount.divide(value.amount).intValue();
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
}
