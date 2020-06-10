package study.lotto.helper;

public class LottoHelper {
    private static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;

    private int manualLottoCount;
    private int autoLottoCount;

    public LottoHelper(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public void setManualLottoCount(int manualLottoCount) {
        this.manualLottoCount = manualLottoCount;
        autoLottoCount = getLottoCount() - manualLottoCount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }
}
