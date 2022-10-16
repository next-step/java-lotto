package lotto.domain;

import java.util.Objects;

public class Amount {

    private final int amount;
    private final static String AMOUNT_BOUND_EXCEPTION = "Amount에는 0이상의 값만 들어올 수 있습니다.";


    public Amount(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(AMOUNT_BOUND_EXCEPTION);
        }
        this.amount = amount;
    }

    public int amount() {
        return amount;
    }

    public Amount minus(final Amount amount) {
        return new Amount(this.amount - amount.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return amount == amount1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return Integer.toString(amount);
    }
}
