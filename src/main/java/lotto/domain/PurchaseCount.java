package lotto.domain;

import java.util.Objects;

public class PurchaseCount {
    private static final int POSITIVE = 0;

    private final int value;

    public PurchaseCount(int value) {
        if (value < POSITIVE) {
            throw new IllegalArgumentException("invalid purchase amount");
        }
        this.value = value;
    }

    public PurchaseCount decrease() {
        return new PurchaseCount(this.value - 1);
    }

    public boolean isPositive() {
        return value > POSITIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseCount purchaseCount = (PurchaseCount) o;
        return value == purchaseCount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
