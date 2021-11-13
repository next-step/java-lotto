package lotto.service.dto;

import lotto.service.value.LottoPrice;
import lotto.utils.Preconditions;
import lotto.validator.LottoValidator;

import java.util.List;

public class LottoPurchaseDTO {
    private final Integer autoLottoQuantity;
    private final List<List<Integer>> manualNumbers;

    private LottoPurchaseDTO(Integer lottoQuantity, List<List<Integer>> manualNumbers) {
        Preconditions.checkNotNull(lottoQuantity, "lottoQuantity는 필수값입니다.");
        Preconditions.checkNotNull(manualNumbers, "manualNumbers는 필수값입니다.");
        LottoValidator.checkManualLottoCount(lottoQuantity, manualNumbers.size());

        this.autoLottoQuantity = lottoQuantity - manualNumbers.size();
        this.manualNumbers = manualNumbers;
    }

    public static LottoPurchaseDTO of(LottoPrice purchasePrice, List<List<Integer>> manualNumbers) {
        return new LottoPurchaseDTO(purchasePrice.getLottoQuantity(), manualNumbers);
    }

    public Integer getAutoLottoQuantity() {
        return autoLottoQuantity;
    }

    public List<List<Integer>> getManualNumbers() {
        return manualNumbers;
    }
}
