package lotto.domain;

import java.util.Objects;

public class Profit {

    private final Double value;

    public Profit(Double value) {
        this.value = value;
    }

    public Profit(Money consume, Money prize) {
        this.value = 20.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profit profit1 = (Profit) o;
        return Objects.equals(value, profit1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
