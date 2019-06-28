package lotto.model;

import java.util.Objects;

public class Quantity {

    int QUANTITY;

    public Quantity(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public boolean exists() {
        return this.QUANTITY > 0;
    }

    public void reduce() {
        if (this.exists()) this.QUANTITY -= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return QUANTITY == quantity.QUANTITY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(QUANTITY);
    }
}
