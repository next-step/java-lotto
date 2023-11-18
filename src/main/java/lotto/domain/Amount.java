package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Amount {
    private int amount;

    public Amount() {
        this.amount = 0;
    }

    public Amount(int amount) {
        this.amount = amount;
    }

    public void add(int value) {
        this.amount += value;
    }

    public BigDecimal divide(int amount,  int digit) {
        BigDecimal numerator = new BigDecimal(this.amount);
        BigDecimal denominator = new BigDecimal(amount);
        return numerator.divide(denominator, digit, RoundingMode.HALF_UP);
    }

    public int amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount that = (Amount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
