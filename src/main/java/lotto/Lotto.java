package lotto;

import lotto.exception.InvalidLottoNumberCount;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberCount();
        }
        this.lottoNumbers = lottoNumbers;
    }
}
