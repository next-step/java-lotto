package lotto.domain.vo;

import java.util.Objects;

public class Profit {

    private final Double value;

    public Profit(Double value) {
        verify(value);
        this.value = value;
    }

    public Profit(Money revenue, Money expense) {
        this(revenue.divide(expense));
    }

    private void verify(Double value) {
        if (value < 0) {
            throw new IllegalArgumentException("profit should be greater than 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profit profit = (Profit) o;
        return Objects.equals(value, profit.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Double getValue() {
        return this.value;
    }
}
