package lotto;

import java.util.Objects;

public class Money {

    private final double amount;

    public Money(long amount) {
        this((double) amount);
    }

    private Money(double amount) {
        this.amount = amount;
    }

    public long purchase(Money lottoPrice) {
        return lottoPrice.divide(this.amount);
    }

    private long divide(double number) {
        if (this.amount > number) {
            throw new IllegalArgumentException("로또를 구매하기에 부족한 금액입니다.");
        }
        return (long) (number / this.amount);
    }

    public Ratio calculateRatio(Money budget) {
        return budget.divideBy(this.amount);
    }

    private Ratio divideBy(double totalPrize) {
        return new Ratio((Math.floor(totalPrize / this.amount  * 100) / 100.0));
    }

    public Money sum(Money other) {
        return other.add(this.amount);
    }

    private Money add(double number) {
        return new Money(this.amount + number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return Double.compare(amount, money.amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
