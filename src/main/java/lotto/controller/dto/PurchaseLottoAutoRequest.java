package lotto.controller.dto;

public class PurchaseLottoAutoRequest {

    private final int purchaseAmount;

    public PurchaseLottoAutoRequest(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
