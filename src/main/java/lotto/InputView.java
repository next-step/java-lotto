package lotto;

public class InputView {
    private static final int MIN_PURCHASE_AMOUNT = 1000;

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("구매 금액은 최소 천원 이상이어야 합니다");
        }
    }
}
