package lotto.domain;

import java.util.Objects;

import static java.lang.String.format;

public class Amount {
    private static final int MINIMUM_AMOUNT = 0;

    private int amount;

    public Amount(int amount) {
        if(amount <= MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(format("금액은 %d원 이하는 안됩니다.", MINIMUM_AMOUNT));
        }

        this.amount = amount;
    }

    public int divide(Amount target) {
        return amount / target.amount;
    }

    public Amount multiple(int multiple) {
        return new Amount(amount * multiple);
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
}
