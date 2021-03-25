package lotto.controller.dto;

public class PurchaseLottoAutoResponse {

    private final int purchaseCount;
    private final int[][] lottoNumberList;

    public PurchaseLottoAutoResponse(int purchaseCount, int[][] lottoNumberList) {
        this.purchaseCount = purchaseCount;
        this.lottoNumberList = lottoNumberList;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public int[][] getLottoNumberList() {
        return lottoNumberList;
    }
}
