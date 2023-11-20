package lotto.domain;

import java.util.InputMismatchException;
import java.util.Objects;

public class PurchaseQuantity {
    private final int quantity;

    public PurchaseQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int find() {
        return this.quantity;
    }

    public PurchaseQuantity diff(PurchaseQuantity diffQuantity) {
        if (isImpossible(diffQuantity)) {
            throw new InputMismatchException("구매한 수량에 맞게 갯수 생성을 해주세요.");
        }
        return new PurchaseQuantity(this.quantity - diffQuantity.find());

    }

    private boolean isImpossible(PurchaseQuantity diffQuantity) {
        return this.quantity < diffQuantity.find();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseQuantity that = (PurchaseQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
