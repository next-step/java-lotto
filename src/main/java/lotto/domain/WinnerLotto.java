package lotto.domain;

import lotto.util.LottoValidationUtils;

import java.util.List;

public class WinnerLotto {

    private List<Integer> lottoNumbers;

    public WinnerLotto(final List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        LottoValidationUtils.validateLottoNumbers(this.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
