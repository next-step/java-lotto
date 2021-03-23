package lotto.dto;

public class ResponsePurchaseCountDTO {
    private final int purchaseCount;

    public ResponsePurchaseCountDTO(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
