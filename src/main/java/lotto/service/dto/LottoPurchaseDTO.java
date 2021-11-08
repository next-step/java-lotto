package lotto.service.dto;

import lotto.utils.Preconditions;

public class LottoPurchaseDTO {
    private final Integer purchaseQuantity;

    private LottoPurchaseDTO(Integer purchaseQuantity) {
        Preconditions.checkNotNull(purchaseQuantity, "purchaseQuantity는 필수값입니다.");

        this.purchaseQuantity = purchaseQuantity;
    }

    public static LottoPurchaseDTO from(Integer purchaseQuantity) {
        return new LottoPurchaseDTO(purchaseQuantity);
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

}
