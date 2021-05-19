package lotto.domain;

import java.util.Objects;

import static java.lang.String.format;

public class PositiveInteger {
    private static final int MINIMUM_AMOUNT = 0;

    private int amount;

    public PositiveInteger(int amount) {
        if(amount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(format("숫자는 %d원 미만은 안됩니다.", MINIMUM_AMOUNT));
        }

        this.amount = amount;
    }

    public int divide(PositiveInteger target) {
        return amount / target.amount;
    }

    public PositiveInteger multiple(int multiple) {
        return new PositiveInteger(amount * multiple);
    }

    public PositiveInteger plus(PositiveInteger target) {
        return new PositiveInteger(amount + target.getAmount());
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveInteger positiveInteger1 = (PositiveInteger) o;
        return amount == positiveInteger1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
