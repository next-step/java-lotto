package lotto.domain;

import java.util.Objects;

public class LottoAmount {

    public static final int LOTTO_AMOUNT = 1_000;

    private final int amount;

    private LottoAmount(int amount) {
        this.amount = amount;
    }

    public int value() {
        return amount;
    }

    public static LottoAmount of(int amount) {
        return new LottoAmount(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoAmount that = (LottoAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public int count() {
        return amount / LOTTO_AMOUNT;
    }

    public int remainderAfterManualPurchase(int manualPurchaseCount) {
        return amount - amountOfManualPurchase(manualPurchaseCount);
    }

    private int amountOfManualPurchase(int manualPurchaseCount) {
        int manualPurchaseAmount = manualPurchaseCount * LOTTO_AMOUNT;
        if (amount < manualPurchaseAmount) {
            throw new IllegalArgumentException("수동 구매에 필요한 금액이 부족합니다 : " + manualPurchaseAmount + "원/" + manualPurchaseCount + "장");
        }
        return manualPurchaseCount * LOTTO_AMOUNT;
    }

}
