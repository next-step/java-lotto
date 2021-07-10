package lotto.model;

public class LottoCounts {
    private static final String CAN_NOT_PURCHASE_MESSAGE = "구입가능한 개수를 초과했습니다.";

    private int purchasableLottoCount;
    private int manualLottoCount;
    private int autoLottoCount;

    public LottoCounts(int purchasableLottoCount) {
        this.purchasableLottoCount = purchasableLottoCount;
    }

    public void purchaseManualLotto(int lottoCount) {
        purchaseLottos(lottoCount);
        this.manualLottoCount += lottoCount;
        this.autoLottoCount = this.purchasableLottoCount - this.manualLottoCount;
        this.purchasableLottoCount = this.purchasableLottoCount - lottoCount;
    }

    public void purchaseAutoLotto() {
        purchaseLottos(autoLottoCount);
        this.purchasableLottoCount = this.purchasableLottoCount - this.autoLottoCount;
    }

    private void purchaseLottos(int purchaseCount) {
        validatePurchasable(purchaseCount);
        this.purchasableLottoCount = this.purchasableLottoCount - purchaseCount;
    }

    private void validatePurchasable(int purchaseCount) {
        if (purchasableLottoCount < purchaseCount) {
            throw new IllegalArgumentException(CAN_NOT_PURCHASE_MESSAGE);
        }
    }

    public int getPurchasableLottoCount() {
        return this.purchasableLottoCount;
    }

    public int getManualLottoCount() {
        return this.manualLottoCount;
    }

    public int getAutoLottoCount() {
        return this.autoLottoCount;
    }
}
