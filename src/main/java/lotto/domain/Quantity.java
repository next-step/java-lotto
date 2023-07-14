package lotto.domain;

import java.util.Objects;

public class Quantity {
    private final int quantity;

    public Quantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity shouldn't be negative.");
        }
        this.quantity = quantity;
    }

    public static Quantity of(Money money, long price) {
        return new Quantity((int) (money.getValue() / price));
    }

    @Override
    public boolean equals(Object o) {
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

    public Quantity subtract(Quantity other) {
        return new Quantity(this.quantity - other.quantity);
    }
}
