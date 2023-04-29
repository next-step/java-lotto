package lotto.domain;

import lotto.util.LottoValidationUtils;

import java.util.List;

public class LottoNumbers {

    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        LottoValidationUtils.validateLottoNumbers(this.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
