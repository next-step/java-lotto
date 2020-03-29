package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    public static final String CURRENCY = "원";
    static final Money ZERO = Money.won(0);

    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("음수는 돈이 될 수 없다");
        }
        this.amount = amount;
    }

    public static Money won(int amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money times(int amount) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(amount)));
    }

    public Money plus(Money other) {
        return new Money(this.amount.add((other.amount)));
    }

    public BigDecimal divide(Money other, int scale, RoundingMode roundingMode) {
        return divide(other.amount, scale, roundingMode);
    }

    public BigDecimal divide(BigDecimal amount) {
        return divide(amount, 0, RoundingMode.DOWN);
    }

    public BigDecimal divide(BigDecimal amount, int scale, RoundingMode roundingMode) {
        return this.amount.divide(amount, scale, roundingMode);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
