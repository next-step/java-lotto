package lotto.domain;

public class PurchaseAmount {

    private final static String MIN_PURCHASE_AMOUNT_MESSAGE = "1000원 이상의 구매금액이 필요합니다.";
    private final static int MIN_PRICE = 1000;
    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount < MIN_PRICE) {
            throw new IllegalStateException(MIN_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
