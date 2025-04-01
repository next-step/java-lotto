package lotto.domain;

import java.util.Objects;

public class Quantity {

    private final int quantity;

    public Quantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("구매 개수는 0보다 작을 수 없습니다.");
        }
        this.quantity = quantity;
    }

    public Quantity(String input) {
        this(Integer.parseInt(input));
    }

    public Quantity minus(Quantity that) {
        if (this.quantity < that.quantity) {
            throw new IllegalArgumentException("구매할 수 없는 수량입니다.");
        }
        return new Quantity(this.quantity - that.quantity);
    }

    public int value() {
        return this.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return quantity == quantity1.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quantity);
    }
}
