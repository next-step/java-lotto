package lotto.service.dto;

import lotto.utils.Preconditions;

import java.util.List;

public class LottoPurchaseDTO {
    private final Integer autoLottoQuantity;
    private final List<List<Integer>> manualNumbers;

    private LottoPurchaseDTO(Integer lottoQuantity, List<List<Integer>> manualNumbers) {
        Preconditions.checkNotNull(lottoQuantity, "lottoQuantity는 필수값입니다.");
        Preconditions.checkNotNull(manualNumbers, "manualNumbers는 필수값입니다.");

        this.autoLottoQuantity = lottoQuantity - manualNumbers.size();
        this.manualNumbers = manualNumbers;
    }

    public static LottoPurchaseDTO from(Integer lottoQuantity, List<List<Integer>> manualNumbers) {
        return new LottoPurchaseDTO(lottoQuantity, manualNumbers);
    }

    public Integer getAutoLottoQuantity() {
        return autoLottoQuantity;
    }

    public List<List<Integer>> getManualNumbers() {
        return manualNumbers;
    }
}
