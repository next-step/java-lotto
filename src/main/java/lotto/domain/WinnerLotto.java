package lotto.domain;

import lotto.util.LottoValidationUtils;

import java.util.LinkedHashSet;
import java.util.List;

public class WinnerLotto {

    private LinkedHashSet<Integer> lottoNumbers;

    public WinnerLotto(final List<Integer> lottoNumbers) {
        this.lottoNumbers = new LinkedHashSet<>(lottoNumbers);
        LottoValidationUtils.validateLottoNumbers(this.lottoNumbers);
    }

    public LinkedHashSet<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
