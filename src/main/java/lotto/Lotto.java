package lotto;

import lotto.exception.InvalidLottoNumberCount;

import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private final LottoNumbers lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this(new LottoNumbers(lottoNumbers));
    }

    public Lotto(LottoNumbers lottoNumbers) {
        if (!lottoNumbers.isSameCount(LOTTO_NUMBER_COUNT)) {
            throw new InvalidLottoNumberCount();
        }
        this.lottoNumbers = lottoNumbers;
    }
}
