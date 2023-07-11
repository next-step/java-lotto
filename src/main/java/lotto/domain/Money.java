package lotto.domain;

import java.util.Objects;

public class Money {

    private final Long value;

    public Money(Long value) {
        if (value < 0) {
            throw new IllegalArgumentException("money amount should greater than 0");
        }
        this.value = value;
    }

    public int calculateQuantity(Money price) {
        return (int) (value / price.value);
    }

    public double calculateYield(Money previous) {
        return (double) value / previous.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
