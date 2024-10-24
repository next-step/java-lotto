package lotto.domain;

import java.util.Objects;

public class LottoQuantity {

    private static final int LOTTO_PRICE = 1000;

    private final int totalQuantity;

    public LottoQuantity(int amount) {
        validateInputValue(amount);
        this.totalQuantity = amount / LOTTO_PRICE;
    }

    private void validateInputValue(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 한장의 금액은 1000원 입니다.");
        }
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getPurchaseAmount() {
        return totalQuantity * LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoQuantity that = (LottoQuantity) o;
        return totalQuantity == that.totalQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalQuantity);
    }
}
