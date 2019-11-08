package com.seok2.lotto.domain.common;


import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private static final String CURRENCY_UNIT = " 원";
    private static final int ZERO_VALUE = 0;
    private static final int ONE_VALUE = 1;
    public static final Money ZERO = of(ZERO_VALUE);

    private final BigDecimal money;

    private Money(BigDecimal money) {
        this.money = money;
    }

    public static Money of(int money) {
        return of(new BigDecimal(money));
    }

    public static Money of(BigDecimal money) {
        return new Money(money);
    }

    public boolean moreThanOrEquals(Money money) {
        return this.money.compareTo(money.money) >= ZERO_VALUE;
    }

    public Money add(Money money) {
        if (money.equals(ZERO)) {
            return this;
        }
        return Money.of(this.money.add(money.money));
    }

    public Money subtract(Money money) {
        if (money.equals(ZERO)) {
            return this;
        }
        return Money.of(this.money.subtract(money.money));
    }

    public Money multiply(long multiplicand) {
        if (multiplicand == ONE_VALUE) {
            return this;
        }
        return Money.of(this.money.multiply(new BigDecimal(multiplicand)));
    }

    public ReturnOnInvestmentRate calculateReturnOnInvestmentRate(Money returnOnInvestment) {
        if (this.equals(ZERO)) {
            return ReturnOnInvestmentRate.of(BigDecimal.ZERO);
        }
        return ReturnOnInvestmentRate.of(this.money.divide(returnOnInvestment.money));
    }

    @Override
    public String toString() {
        return money + CURRENCY_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money that = (Money) o;
        return Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
