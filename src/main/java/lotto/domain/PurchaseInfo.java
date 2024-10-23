package lotto.domain;

public class PurchaseInfo {
    private static final int LOTTO_PRICE = 1000;
    private final int totalNumberOfLotto;
    private final int numberOfManualPurchase;

    public PurchaseInfo(int purchaseAmount, int manualPurchase) {
        this.totalNumberOfLotto = calculateNumberOfAutoPurchase(purchaseAmount);
        this.numberOfManualPurchase = manualPurchase;
    }

    private int calculateNumberOfAutoPurchase(int autoPurchase) {
        return autoPurchase / LOTTO_PRICE;
    }

    public int getNumberOfManualPurchase() {
        return numberOfManualPurchase;
   }

   public int getNumberOfAutoPurchase() {
        return totalNumberOfLotto - numberOfManualPurchase;
   }


    public int getPruchaseAmount() {
        return 1000 * totalNumberOfLotto;
    }
}
