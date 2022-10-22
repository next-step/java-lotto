package lotto.domain;

import lotto.util.LottoUtil;

import java.util.List;

public class LottoDto {

    List<Integer> lottoNumbers;

    public LottoDto (List<Number> lottoNumbers) {
        this.lottoNumbers = LottoUtil.convertToIntegers(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
