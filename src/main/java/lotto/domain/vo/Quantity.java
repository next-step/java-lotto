package lotto.domain.vo;

import java.util.Objects;

public class Quantity {

    private final int value;

    public Quantity(int quantity) {
        verify(quantity);
        this.value = quantity;
    }

    public Quantity subtract(Quantity other) {
        if (this.value < other.value) {
            throw new IllegalArgumentException("quantity can't be less than 0");
        }
        return new Quantity(this.value - other.value);
    }

    public int getValue() {
        return value;
    }

    private void verify(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("quantity should be greater than 0");
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
        Quantity quantity1 = (Quantity) o;
        return value == quantity1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
