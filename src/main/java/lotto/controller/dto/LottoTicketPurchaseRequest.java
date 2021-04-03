package lotto.controller.dto;

import java.util.List;

public class LottoTicketPurchaseRequest {

    private final int purchaseAmount;
    private final int manualLottoPurchaseCount;
    private final List<String> manualLottoPurchaseNumberList;

    public LottoTicketPurchaseRequest(int purchaseAmount, int manualLottoPurchaseCount, List<String> manualLottoPurchaseNumberList) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoPurchaseCount = manualLottoPurchaseCount;
        this.manualLottoPurchaseNumberList = manualLottoPurchaseNumberList;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getManualLottoPurchaseCount() {
        return manualLottoPurchaseCount;
    }

    public List<String> getManualLottoPurchaseNumberList() {
        return manualLottoPurchaseNumberList;
    }
}
