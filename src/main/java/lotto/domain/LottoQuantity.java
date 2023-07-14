package lotto.domain;

import java.util.Objects;

public class LottoQuantity {
    private final int quantity;

    public LottoQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static LottoQuantity of(Money money, long price) {
        return new LottoQuantity((int) (money.getValue() / price));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoQuantity that = (LottoQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}
