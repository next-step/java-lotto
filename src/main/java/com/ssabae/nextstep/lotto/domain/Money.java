package com.ssabae.nextstep.lotto.domain;


import java.math.BigDecimal;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class Money {

    public static Money ZERO = new Money(BigDecimal.valueOf(0));
    public BigDecimal amount;

    public Money(BigDecimal amount) {
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

}
