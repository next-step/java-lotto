package lotto.model;

public class PurchaseCalculator {
    private static final int LOTTERY_PRICE = 1000;

    private final int purchaseAmount;
    private LottoCount lottoCount;

    public PurchaseCalculator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoCount = new LottoCount(purchaseAmount / LOTTERY_PRICE);
    }

    public void purchaseLottos(int purchaseCount) {
        this.lottoCount.purchaseLotto(purchaseCount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchasableLottoCounts() {
        return this.lottoCount.getPurchasableLottoCount();
    }
}
