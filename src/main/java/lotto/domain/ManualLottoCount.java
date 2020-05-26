package lotto.domain;

import java.util.Objects;

public class ManualLottoCount {

    private static final int MIN_MANUAL_LOTTO_COUNT = 0;

    private final int manualLottoCount;

    private ManualLottoCount(int manualLottoCount, PurchaseAmount purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        validateManualLottoCount(manualLottoCount, purchaseAmount);

        this.manualLottoCount = manualLottoCount;
    }

    public static ManualLottoCount newInstance(int manualLottoCount, PurchaseAmount purchaseAmount) {
        return new ManualLottoCount(manualLottoCount, purchaseAmount);
    }

    private void validatePurchaseAmount(PurchaseAmount purchaseAmount) {
        if (purchaseAmount == null) {
            throw new IllegalArgumentException("구입금액이 존재하지 않습니다.");
        }
    }

    private void validateManualLottoCount(int manualLottoCount, PurchaseAmount purchaseAmount) {
        if (manualLottoCount < MIN_MANUAL_LOTTO_COUNT) {
            throw new IllegalArgumentException("수동 구매 로또 수를 0 보다 작게 입력할 수 없습니다.");
        }

        if (manualLottoCount > purchaseAmount.calculatePurchaseCount()) {
            throw new IllegalArgumentException("구입할 수 있는 로또 수를 초과하였습니다.");
        }
    }

    public int getManualLottoCount() {
        return this.manualLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualLottoCount that = (ManualLottoCount) o;
        return manualLottoCount == that.manualLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualLottoCount);
    }
}
