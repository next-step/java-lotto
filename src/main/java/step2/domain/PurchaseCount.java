package step2.domain;

import java.util.Objects;

public class PurchaseCount {

    private static final int DEFAULT_EACH_LOTTO_PRICE = 1000;

    private final int value;

    public PurchaseCount(int purchaseAmount) {
        this(purchaseAmount, DEFAULT_EACH_LOTTO_PRICE);
    }

    public PurchaseCount(int purchaseAmount, int eachPrice) {
        validateEachLottoPrice(eachPrice);
        validateInput(purchaseAmount);
        validateLeast(purchaseAmount, eachPrice);
        validateDivisible(purchaseAmount, eachPrice);
        this.value = purchaseAmount / eachPrice;
    }

    private void validateEachLottoPrice(int eachPrice) {
        if (eachPrice < 0) {
            throw new IllegalArgumentException("로또 한 장의 가격은 양수여야합니다.");
        }
    }

    private void validateInput(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 작을 수 없습니다.");
        }
    }

    private void validateLeast(int purchaseAmount, int eachPrice) {
        if (purchaseAmount < eachPrice) {
            throw new IllegalArgumentException("로또 한 개의 금액보다 적게 살 수 없습니다.");
        }
    }

    private void validateDivisible(int purchaseAmount, int eachPrice) {
        if (purchaseAmount % eachPrice != 0) {
            throw new IllegalArgumentException("로또 구매는 로또 한 개의 금액의 배수로 이루어져야합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseCount that = (PurchaseCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
