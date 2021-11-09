package lotto.controller.dto;

import lotto.service.value.LottoPrice;
import lotto.utils.Preconditions;

public class LottoPurchaseRequest {
    private final LottoPrice purchasePrice;

    private LottoPurchaseRequest(LottoPrice purchasePrice) {
        Preconditions.checkNotNull(purchasePrice, "purchasePrice는 필수값입니다.");

        this.purchasePrice = purchasePrice;
    }

    public static LottoPurchaseRequest from(LottoPrice purchasePrice) {
        return new LottoPurchaseRequest(purchasePrice);
    }

    public LottoPrice getPurchasePrice() {
        return purchasePrice;
    }
}
