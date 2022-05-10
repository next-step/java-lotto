package step2.domain;

import java.util.Objects;

public class PurchaseMoney {

    private static final int DEFAULT_EACH_LOTTO_PRICE = 1000;

    private final int purchaseAmount;

    public PurchaseMoney(int purchaseAmount) {
        validateInput(purchaseAmount);
        validateLeast(purchaseAmount);
        validateDivisible(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateInput(int purchaseAmount) {
        if (purchaseAmount < DEFAULT_EACH_LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액은 " + DEFAULT_EACH_LOTTO_PRICE + " 보다 작을 수 없습니다.");
        }
    }

    private void validateLeast(int purchaseAmount) {
        if (purchaseAmount < DEFAULT_EACH_LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 한 개의 금액보다 적게 살 수 없습니다.");
        }
    }

    private void validateDivisible(int purchaseAmount) {
        if (purchaseAmount % DEFAULT_EACH_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구매는 로또 한 개의 금액의 배수로 이루어져야합니다.");
        }
    }

    public ReturnRate calculateReturnRate(int sumOfPrizeMoney) {
        return new ReturnRate(sumOfPrizeMoney, purchaseAmount);
    }

    public int calculatePurchaseCount() {
        return purchaseAmount / DEFAULT_EACH_LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseMoney that = (PurchaseMoney) o;
        return purchaseAmount == that.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseAmount);
    }
}
