package step2.domain;

import java.util.Objects;

public class LottoQuantity {
    private final Long quantity;

    public LottoQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void validateLottoSize(final int lottoSize) {
        if (quantity < lottoSize) {
            throw new IllegalArgumentException("구매 가능한 수량보다 많습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        LottoQuantity that = (LottoQuantity) o;
        return Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
