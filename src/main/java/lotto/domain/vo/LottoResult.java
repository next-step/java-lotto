package lotto.domain.vo;

import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoNumbers;

import java.util.List;

public class LottoResult {
    private final LottoNumbers lottoNumbers;

    public LottoResult(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.getValue();
    }
}
