package lotto.controller.dto;

import java.util.List;

public class LottoTicketPurchaseRequest {

    private final int purchaseAmount;
    private final List<String> manualLottoPurchaseNumberList;

    public LottoTicketPurchaseRequest(int purchaseAmount, List<String> manualLottoPurchaseNumberList) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoPurchaseNumberList = manualLottoPurchaseNumberList;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<String> getManualLottoPurchaseNumberList() {
        return manualLottoPurchaseNumberList;
    }
}
