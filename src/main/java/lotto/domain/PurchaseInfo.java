package lotto.domain;

public class PurchaseInfo {
    private static final int LOTTO_PRICE = 1000;
    private final int totalNumberOfLotto;
    private final int numberOfManualPurchase;

    public PurchaseInfo(int purchaseAmount, int manualPurchase) {
        this.totalNumberOfLotto = calculateNumberOfTotalPurchase(purchaseAmount);
        this.numberOfManualPurchase = manualPurchase;
        validNumberOfManualLotto();
    }

    private void validNumberOfManualLotto() {
        if (numberOfManualPurchase > totalNumberOfLotto) {
            throw new IllegalArgumentException("구매한 로또 수량보다 많의 수의 로또를 수동 구매 할 수 없습니다");
        }
    }

    private int calculateNumberOfTotalPurchase(int totalAmount) {
        checkIfCanPurchaseLotto(totalAmount);
        return totalAmount / LOTTO_PRICE;
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

    private void checkIfCanPurchaseLotto(int totalAmount) {
        if (totalAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 미만으론 살 수 없음");
        }
    }

}
