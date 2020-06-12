package study.lotto.domain;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final int manualLottoCount;

    public LottoPurchase(int purchaseAmount, int manualLottoCount) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoCount = manualLottoCount;
    }

    public int getLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return getLottoCount() - manualLottoCount;
    }
}
