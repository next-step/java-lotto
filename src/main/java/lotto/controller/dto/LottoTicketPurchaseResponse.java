package lotto.controller.dto;

import java.util.List;

public class LottoTicketPurchaseResponse {

    private final int manualPurchaseCount;
    private final int autoPurchaseCount;
    private final List<String> lottoNumberList;

    public LottoTicketPurchaseResponse(int manualPurchaseCount, int autoPurchaseCount, List<String> lottoNumberList) {
        this.manualPurchaseCount = manualPurchaseCount;
        this.autoPurchaseCount = autoPurchaseCount;
        this.lottoNumberList = lottoNumberList;
    }

    public int getManualPurchaseCount() {
        return manualPurchaseCount;
    }

    public int getAutoPurchaseCount() {
        return autoPurchaseCount;
    }

    public List<String> getLottoNumberList() {
        return lottoNumberList;
    }
}
