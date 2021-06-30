package lotto.model;

public class PurchaseCalculator {
    private static final int LOTTERY_PRICE = 1000;
    private static final String CAN_NOT_PURCHASE_MESSAGE = "구입가능한 개수를 초과했습니다.";

    private final int purchaseAmount;
    private int purchasableLottoCounts;

    public PurchaseCalculator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchasableLottoCounts = purchaseAmount / LOTTERY_PRICE;
    }

    public void buySomeBunchOfLotto(int lottoCount) {
        validateManualLottoCount(lottoCount);
        this.purchasableLottoCounts = purchasableLottoCounts - lottoCount;
    }

    private void validateManualLottoCount(int lottoCount) {
        if (purchasableLottoCounts < lottoCount) {
            throw new IllegalArgumentException(CAN_NOT_PURCHASE_MESSAGE);
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchasableLottoCounts() {
        return this.purchasableLottoCounts;
    }
}
