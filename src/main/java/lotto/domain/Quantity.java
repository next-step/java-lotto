package lotto.domain;

import java.util.Objects;

public class Quantity {
    private final int quantity;

    public Quantity(final int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity shouldn't be negative.");
        }
        this.quantity = quantity;
    }

    public static Quantity of(final Money budget, final int productPrice) {
        return new Quantity((int) (budget.getValue() / productPrice));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity that = (Quantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public Quantity subtract(final Quantity other) {
        return new Quantity(this.quantity - other.quantity);
    }
}
