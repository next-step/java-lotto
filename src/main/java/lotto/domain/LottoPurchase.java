package lotto.domain;

class LottoPurchase {
    public static final int LOTTO_PRICE = 1_000;

    private final int purchaseAmount;
    private final int autoLottoGeneratedCount;
    private final int manualLottoCount;

    private LottoPurchase(int purchaseAmount, int autoLottoGeneratedCount, int manualLottoCount) {
        this.purchaseAmount = purchaseAmount;
        this.autoLottoGeneratedCount = autoLottoGeneratedCount;
        this.manualLottoCount = manualLottoCount;
    }

    static LottoPurchase buyAllAuto(int purchaseAmount){
        return new LottoPurchase(purchaseAmount, purchaseAmount / LOTTO_PRICE, 0);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getAutoLottoGeneratedCount() {
        return autoLottoGeneratedCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
