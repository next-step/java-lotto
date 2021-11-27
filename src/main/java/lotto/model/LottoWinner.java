package lotto.model;

import common.model.Number;

import java.util.List;

public class LottoWinner extends LottoNumbers {

    private final LottoNumber bonusNumber;

    public LottoWinner(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }
    
    public LottoRank match(LottoNumbers matchNumbers) {
        Number count = new Number();

        for (LottoNumber lottoNumber : super.lottoNumbers) {
            matchNumbers.match(lottoNumber, count);
        }

        boolean isBonus = matchNumbers.contains(bonusNumber);

        return LottoRank.valueOf(count, isBonus);
    }

}
