package lotto.domain;

public class LottoPurchase {
    private static final int PRICE = 1000;

    private final int purchaseAmount;

    public LottoPurchase(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < PRICE) {
            throw new IllegalArgumentException("구매 금액은 최소 " + PRICE + "원 이상이어야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int calculateLottoCount() {
        return purchaseAmount / PRICE;
    }

}
