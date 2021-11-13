package lotto.service.dto;

import lotto.service.model.LottoNumbers;
import lotto.service.value.LottoPrice;
import lotto.utils.Preconditions;
import lotto.validator.LottoValidator;

import java.util.List;

public class LottoPurchaseDTO {
    private final Integer autoLottoQuantity;

    private final List<LottoNumbers> lottoNumbersList;

    private LottoPurchaseDTO(Integer lottoQuantity, List<LottoNumbers> lottoNumbersList) {
        Preconditions.checkNotNull(lottoQuantity, "lottoQuantity는 필수값입니다.");
        Preconditions.checkNotNull(lottoNumbersList, "lottoNumbersList는 필수값입니다.");
        LottoValidator.checkManualLottoCount(lottoQuantity, lottoNumbersList.size());

        this.autoLottoQuantity = lottoQuantity - lottoNumbersList.size();
        this.lottoNumbersList = lottoNumbersList;
    }

    public static LottoPurchaseDTO of(LottoPrice purchasePrice, List<LottoNumbers> lottoNumbers) {
        return new LottoPurchaseDTO(purchasePrice.getLottoQuantity(), lottoNumbers);
    }

    public Integer getAutoLottoQuantity() {
        return autoLottoQuantity;
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }
}
