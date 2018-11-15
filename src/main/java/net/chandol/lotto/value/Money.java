package net.chandol.lotto.value;

import java.util.Objects;

public class Money implements Comparable<Money>{
    private int value;

    private Money(int value) {
        this.value = value;
    }

    public Money add(Money money) {
        return of(this.value + money.value);
    }

    public Money add(int moneyValue) {
        return of(this.value + moneyValue);
    }

    public Money subtract(Money money) {
        return of(this.value - money.value);
    }

    public Money subtract(int moneyValue) {
        return of(this.value - moneyValue);
    }

    public Money multiply(int number) {
        return of(this.value * number);
    }

    public Money divide(int number) {
        return of(this.value / number);
    }

    public Money divide(Money money) {
        return of(this.value / money.getValue());
    }

    public int divideAsNumber(Money money){
        return this.value / money.getValue();
    }

    public int divideAsNumber(Integer value){
        return this.value / value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Money other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static final Money ZERO = Money.of(0);

    public static Money of(int money) {
        return new Money(money);
    }

    public double calculateProfitRate(Money purchasePrice) {
        return value * 1d / purchasePrice.value;
    }
}
