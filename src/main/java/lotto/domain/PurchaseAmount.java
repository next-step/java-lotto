package lotto.domain;

public class PurchaseAmount {

    public static final int AMOUNT_PER_LOTTO = 1000;
    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {

        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchasedLottosCount() {

        return purchaseAmount / AMOUNT_PER_LOTTO;
    }

    private void validatePurchaseAmount(int purchaseAmount) {

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다. 구매금액=" + purchaseAmount);
        }
        if (purchaseAmount % AMOUNT_PER_LOTTO != 0) {
            throw new IllegalArgumentException("로또구매는 " + AMOUNT_PER_LOTTO + "원 단위로만 가능합니다. 구매금액=" + purchaseAmount);
        }
    }

}
