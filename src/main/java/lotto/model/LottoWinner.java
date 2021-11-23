package lotto.model;

import common.model.Number;

import java.util.List;

public class LottoWinner extends LottoNumbers {
    public LottoWinner(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public void match(LottoNumber lottoNumber, Number matchCount) {
        if (contains(lottoNumber)) {
            matchCount.plus();
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

}
