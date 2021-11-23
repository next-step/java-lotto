package lotto.model;

import common.model.Number;

import java.util.List;

public class LottoWinner extends LottoNumbers {

    public LottoWinner(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public LottoRank match(LottoNumbers lottoNumbers) {
        Number count = new Number();
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            match(lottoNumber, count);
        }
        return LottoRank.valueOf(count);
    }

    public void match(LottoNumber lottoNumber, Number count) {
        if (contains(lottoNumber)) {
            count.plus();
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

}
