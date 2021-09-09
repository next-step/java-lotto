package step2.domain.statistics;

import java.util.Objects;

public class Amount implements Comparable<Amount> {
    private static final int LOTTO_PRICE = 1000;

    private int amount;

    public Amount() {
        this(0);
    }

    public Amount(int amount) {
        if (amount < 0) {
            final String message = String.format("0개(%d원) 미만은 구매할 수 없습니다.", LOTTO_PRICE);
            throw new RuntimeException(message);
        }
        this.amount = amount;
    }

    public Amount(Amount amount) {
        this.amount = amount.amount;
    }

    public double price() {
        return (double) amount * LOTTO_PRICE;
    }

    public Amount add() {
        return new Amount(this.amount + 1);
    }

    public Amount minus(Amount amount) {
        return new Amount(this.amount - amount.amount);
    }

    public boolean isLessThan(int amount) {
        return this.amount > amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amount)) return false;
        Amount amount1 = (Amount) o;
        return amount == amount1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }

    @Override
    public int compareTo(Amount amount) {
        return this.amount - amount.amount;
    }
}
