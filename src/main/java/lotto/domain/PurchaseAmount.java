package lotto.domain;

public class PurchaseAmount {
    public static final String PURCHASE_AMOUNT_MINUS_ERROR_MESSAGE = "구입금액은 음수일 수 없습니다.";

    int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MINUS_ERROR_MESSAGE);
        }
    }

    public int getLottoCount() {
        return purchaseAmount / Lotto.LOTTO_PRICE;
    }
}
