package step2.domain.lotto;

import step2.domain.PurchaseAmount;

public class LottoPurchaseManager {
    private final PurchaseAmount purchasedAmount;
    private final LottoCount autoLottoCount;
    private final LottoCount manualLottoCount;

    public LottoPurchaseManager(PurchaseAmount purchaseAmount, int lottoPrice, int manualLottoCount) {
        this.purchasedAmount = purchaseAmount;
        this.manualLottoCount = new LottoCount(manualLottoCount);
        this.autoLottoCount = computeAutoLottoCount(purchaseAmount, lottoPrice);
    }

    public LottoContainer generateAutoLottoContainer(LottoGenerator lottoGenerator) {
            return new LottoContainer(autoLottoCount.value(), lottoGenerator);
    }

    private LottoCount computeAutoLottoCount(PurchaseAmount purchaseAmount, int lottoPrice) {
        LottoCount totalLottoCount = purchaseAmount.getLottoCount(lottoPrice);
        if (this.manualLottoCount.isBiggerThan(totalLottoCount)) {
            String validationMessage = "수동 로또 개수는 전체 로또 개수보다 작거나 같아야 합니다.";
            throw new IllegalArgumentException(validationMessage);
        }
        return totalLottoCount.subtract(this.manualLottoCount);
    }

    public PurchaseAmount getPurchaseAmount() {
        return this.purchasedAmount;
    }
}
