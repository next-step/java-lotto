package lotto.controller.dto;

import lotto.utils.Preconditions;

public class LottoPurchaseRequest {
    private final Integer purchasePrice;

    private LottoPurchaseRequest(Integer purchasePrice) {
        Preconditions.checkNotNull(purchasePrice, "purchasePrice는 필수값입니다.");

        this.purchasePrice = purchasePrice;
    }

    public static LottoPurchaseRequest from(Integer purchasePrice) {
        return new LottoPurchaseRequest(purchasePrice);
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }
}
