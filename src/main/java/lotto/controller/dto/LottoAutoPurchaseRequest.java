package lotto.controller.dto;

public class LottoAutoPurchaseRequest {

    private final int purchaseAmount;

    public LottoAutoPurchaseRequest(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
