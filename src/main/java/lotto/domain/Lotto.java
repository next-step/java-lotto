package lotto.domain;

import lotto.exception.InvalidLottoNumberCount;

import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private int matchCount;
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

    public void confirm(List<LottoNumber> winningNumbers) {
        matchCount = lottoNumbers.matchCount(winningNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
