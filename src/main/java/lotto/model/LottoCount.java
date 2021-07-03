package lotto.model;

public class LottoCount {
    private static final String CAN_NOT_PURCHASE_MESSAGE = "구입가능한 개수를 초과했습니다.";

    private int purchasableLottoCount;

    public LottoCount(int purchasableLottoCount) {
        this.purchasableLottoCount = purchasableLottoCount;
    }

    public void purchaseLotto(int purchaseCount) {
        isPurchasable(purchaseCount);
        this.purchasableLottoCount = purchasableLottoCount - purchaseCount;
    }

    private boolean isPurchasable(int purchaseCount) {
        if (purchasableLottoCount < purchaseCount) {
            throw new IllegalArgumentException(CAN_NOT_PURCHASE_MESSAGE);
        }
        return true;
    }

    public int getPurchasableLottoCount() {
        return purchasableLottoCount;
    }
}
