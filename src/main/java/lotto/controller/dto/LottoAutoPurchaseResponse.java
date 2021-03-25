package lotto.controller.dto;

import java.util.List;

public class LottoAutoPurchaseResponse {

    private final int purchaseCount;
    private final List<String> lottoNumberList;

    public LottoAutoPurchaseResponse(int purchaseCount, List<String> lottoNumberList) {
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
