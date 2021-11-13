package lotto.service.model;

import lotto.utils.Preconditions;

import java.util.List;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    private LottoNumbers(List<Integer> lottoNumbers) {
        Preconditions.checkNotNull(lottoNumbers, "lottoNumbers는 필수값입니다.");
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(List<Integer> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
