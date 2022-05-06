package step2.domain;

import java.util.Objects;

public class PurchaseMoney {

    private static final int DEFAULT_EACH_LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final int purchaseCount;

    public PurchaseMoney(int purchaseAmount) {
        this(purchaseAmount, DEFAULT_EACH_LOTTO_PRICE);
    }

    public PurchaseMoney(int purchaseAmount, int eachPrice) {
        validateEachLottoPrice(eachPrice);
        validateInput(purchaseAmount);
        validateLeast(purchaseAmount, eachPrice);
        validateDivisible(purchaseAmount, eachPrice);
        this.purchaseAmount = purchaseAmount;
        this.purchaseCount = purchaseAmount / eachPrice;
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

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseMoney that = (PurchaseMoney) o;
        return purchaseCount == that.purchaseCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseCount);
    }
}
