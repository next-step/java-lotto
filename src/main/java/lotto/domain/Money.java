package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private final BigDecimal amount;

    public Money(Integer amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public Integer divideBy(Integer price) {
        return this.amount
                .divide(BigDecimal.valueOf(price), BigDecimal.ROUND_DOWN)
                .intValue();
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount).intValue());
    }

    public double rate(Money investment) {
        if (investment.amount.compareTo(BigDecimal.ZERO) == 0) {
            return 0.0;
        }
        return this.amount
                .divide(investment.amount, 2, BigDecimal.ROUND_DOWN)
                .doubleValue();
    }

    public int intValue() {
        return amount.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }
}
