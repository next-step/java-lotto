package lotto.controller.dto;

public class LottoPurchaseRequest {

    private final int purchaseAmount;

    public LottoPurchaseRequest(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
