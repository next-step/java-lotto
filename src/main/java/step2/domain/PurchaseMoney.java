package step2.domain;

import java.util.Objects;

public class PurchaseMoney {


    private static final int DEFAULT_EACH_LOTTO_PRICE = 1000;

    private final int amount;
    private final int manualCount;

    public PurchaseMoney(int amount) {
        this(amount, 0);
    }

    public PurchaseMoney(int amount, int manualCount) {
        validateLeast(amount);
        validateDivisible(amount);
        this.amount = amount;

        validateManualCount(manualCount);
        validateMaxManualCount(manualCount);
        this.manualCount = manualCount;
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

    private void validateManualCount(int manualCount) {
        if (manualCount < 0) {
            throw new IllegalArgumentException("수동 구매 갯수는 0 보다 작을 수 없습니다.");
        }
    }

    private void validateMaxManualCount(int manualCount) {
        int sumOfManual = DEFAULT_EACH_LOTTO_PRICE * manualCount;
        if (amount - sumOfManual < 0) {
            throw new IllegalArgumentException("수동 구매 갯수가 총 구매금액을 초과합니다.");
        }
    }

    public ReturnRate calculateReturnRate(int sumOfPrizeMoney) {
        return new ReturnRate(sumOfPrizeMoney, amount);
    }

    public int calculateManualPurchaseCount() {
        return this.manualCount;
    }

    public int calculateAutoPurchaseCount() {
        return amount / DEFAULT_EACH_LOTTO_PRICE - this.manualCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseMoney that = (PurchaseMoney) o;
        return amount == that.amount && manualCount == that.manualCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, manualCount);
    }
}
