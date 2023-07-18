package lotto.domain.vo;

import java.util.Objects;

public class Quantity {

    private final long value;

    public Quantity(long quantity) {
        verify(quantity);
        this.value = quantity;
    }

    public Quantity subtract(Quantity other) {
        verify(this.value - other.value);
        return new Quantity(this.value - other.value);
    }

    public Quantity subtract(Integer other) {
        verify(this.value - other);
        return new Quantity(this.value - other);
    }

    public boolean isUnderThan(Integer other) {
        return value < other;
    }

    public long getValue() {
        return value;
    }

    private void verify(long value) {
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
