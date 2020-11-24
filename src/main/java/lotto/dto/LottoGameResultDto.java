package lotto.dto;

import lotto.domain.LottoGameResult;
import lotto.domain.PurchaseAmount;

public class LottoGameResultDto {

    private final LottoGameResult result;
    private final PurchaseAmount purchaseAmount;

    public LottoGameResultDto(LottoGameResult result, PurchaseAmount purchaseAmount) {
        this.result = result;
        this.purchaseAmount = purchaseAmount;
    }

    public LottoGameResult getResult() {
        return result;
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }
}
