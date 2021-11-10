package lotto.service.dto;

import lotto.utils.Preconditions;

public class LottoPurchaseDTO {
    private final Integer lottoQuantity;

    private LottoPurchaseDTO(Integer lottoQuantity) {
        Preconditions.checkNotNull(lottoQuantity, "lottoQuantity는 필수값입니다.");

        this.lottoQuantity = lottoQuantity;
    }

    public static LottoPurchaseDTO from(Integer lottoQuantity) {
        return new LottoPurchaseDTO(lottoQuantity);
    }

    public Integer getLottoQuantity() {
        return lottoQuantity;
    }

}
