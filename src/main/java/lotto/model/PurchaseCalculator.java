package lotto.model;

public class PurchaseCalculator {
    private static final int LOTTERY_PRICE = 1000;
    private static final String CAN_NOT_PURCHASE_MESSAGE = "구입가능한 개수를 초과했습니다.";
    private static final int PURCHASABLE_COUNT = 0;

    private final int purchaseAmount;
    private int leftLottoCounts;

    public PurchaseCalculator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.leftLottoCounts = purchaseAmount / LOTTERY_PRICE;
    }

    public int getPurchasableCount() {
        return this.leftLottoCounts;
    }

    public void buySomeBunchOfLotto(int lottoCount) {
        validateManualLottoCount(lottoCount);
        this.leftLottoCounts = leftLottoCounts - lottoCount;
    }

    private void validateManualLottoCount(int lottoCount) {
        if (leftLottoCounts - lottoCount < PURCHASABLE_COUNT) {
            throw new IllegalArgumentException(CAN_NOT_PURCHASE_MESSAGE);
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
