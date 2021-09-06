package step2.domain.statistics;

import java.util.Objects;

public class Amount {
    private static final int LOTTO_PRICE = 1000;

    private int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public Amount() {
        this(0);
    }

    public double price() {
        return (double) amount * LOTTO_PRICE;
    }

    public Amount add() {
        return new Amount(this.amount + 1);
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
        return new StringBuilder()
                .append(amount)
                .append("개를 구매했습니다.")
                .toString();
    }
}
