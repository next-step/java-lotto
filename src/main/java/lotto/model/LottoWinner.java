package lotto.model;

import common.model.Number;

import java.util.List;

public class LottoWinner extends LottoNumbers {

    private LottoNumber bonusNumber;

    public LottoWinner(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoWinner(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public LottoRank match(LottoNumbers lottoNumbers) {
        Number count = new Number();
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            match(lottoNumber, count);
        }

        boolean isBonus = bonusMatch(lottoNumbers);
        return LottoRank.valueOf(count, isBonus);
    }

    public void match(LottoNumber lottoNumber, Number count) {
        if (contains(lottoNumber)) {
            count.plus();
        }
    }

    public boolean bonusMatch(LottoNumbers lottoNumbers) {
        return lottoNumbers.getLottoNumbers().contains(bonusNumber);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

}
