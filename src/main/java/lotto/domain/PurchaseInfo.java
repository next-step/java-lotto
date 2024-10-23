package lotto.domain;

public class PurchaseInfo {
    private static final int LOTTO_PRICE = 1000;
    private final int totalNumberOfLotto;
    private final int numberOfManualPurchase;

    public PurchaseInfo(int purchaseAmount, int manualPurchase) {
        validNumberOfManualLotto(purchaseAmount, manualPurchase);
        validmanualPurchaseIsNegatibe(manualPurchase);
        this.totalNumberOfLotto = calculateNumberOfTotalPurchase(purchaseAmount);
        this.numberOfManualPurchase = manualPurchase;
    }

    private void validNumberOfManualLotto(int purchaseAmount, int manualPurchase) {
        if (manualPurchase > purchaseAmount) {
            throw new IllegalArgumentException("구매한 로또 수량보다 많의 수의 로또를 수동 구매 할 수 없습니다");
        }
    }

    private void validmanualPurchaseIsNegatibe(int manualPurchase) {
        if (manualPurchase < 0) {
            throw new IllegalArgumentException("0 이상의 숫자를 입력해야 합니다");
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
