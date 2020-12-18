package com.ssabae.nextstep.lotto.domain;


import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class Money {

    public static Money ZERO = new Money(BigDecimal.valueOf(0));

    public BigDecimal amount;

    private Money(BigDecimal amount) {
        if (amount.intValue() < 0) {
            throw new IllegalArgumentException("0보다 작은 숫자는 들어올 수 없습니다.");
        }
        this.amount = amount;
    }

    public static Money won(Long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money money) {
        return new Money(this.amount.add(money.amount));
    }

    public Money minus(Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public Money divide(double percent) {
        return new Money(this.amount.divide(BigDecimal.valueOf(percent), 2, BigDecimal.ROUND_UP));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
