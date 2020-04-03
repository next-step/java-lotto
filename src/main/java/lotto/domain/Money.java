package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;

    public static Money of(String value) {
        return new Money(new BigDecimal(value));
    }

    public static Money of(long value) {
        return new Money(BigDecimal.valueOf(value));
    }

    private Money(BigDecimal amount) {
        this.amount = amount;
    }

    public long divide(Money anotherMoney) {
        return amount.divide(anotherMoney.getAmount(), RoundingMode.DOWN)
                .longValue();
    }

    public Money multiply(long number) {
        return new Money(amount.multiply(BigDecimal.valueOf(number)));
    }

    public BigDecimal calculateProfit(Money anotherMoney) {
        return amount.divide(anotherMoney.getAmount(), 2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
