package lotto.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketPurchaseRequest {

    private final int purchaseAmount;
    private final List<String> manualLottoPurchaseNumberList;
    private final int manualLottoPurchaseCount;

    public LottoTicketPurchaseRequest(int purchaseAmount, List<String> manualLottoPurchaseNumberList) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoPurchaseNumberList = manualLottoPurchaseNumberList;
        this.manualLottoPurchaseCount = manualLottoPurchaseNumberList.size();
    }

    public LottoTicketPurchaseRequest(int purchaseAmount, int manualLottoPurchaseCount) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottoPurchaseCount = manualLottoPurchaseCount;
        this.manualLottoPurchaseNumberList = new ArrayList<>();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<String> getManualLottoPurchaseNumberList() {
        return manualLottoPurchaseNumberList;
    }

    public int getManualLottoPurchaseCount() {
        return manualLottoPurchaseCount;
    }
}
