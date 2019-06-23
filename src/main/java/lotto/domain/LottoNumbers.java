package lotto.domain;

import lotto.common.LottoNumbersMaker;

import java.util.List;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;
    
    public LottoNumbers() {
        this.lottoNumbers = LottoNumbersMaker.getNewLottoNumbers();
    }
}
