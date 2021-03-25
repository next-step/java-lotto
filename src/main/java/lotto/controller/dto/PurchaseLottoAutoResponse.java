package lotto.controller.dto;

import java.util.List;

public class PurchaseLottoAutoResponse {

    private final int purchaseCount;
    private final List<String> lottoNumberList;

    public PurchaseLottoAutoResponse(int purchaseCount, List<String> lottoNumberList) {
        this.purchaseCount = purchaseCount;
        this.lottoNumberList = lottoNumberList;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public List<String> getLottoNumberList() {
        return lottoNumberList;
    }
}
