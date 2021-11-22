package lotto.domain;

import lotto.exception.LottoNumbersCountException;

import java.util.List;

public abstract class AbstractLotto {
    private static final int WINNING_NUMBERS_COUNT = 6;

    protected final List<LottoNumber> lottoNumbers;

    protected AbstractLotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumberCount(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumberCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != WINNING_NUMBERS_COUNT) {
            throw new LottoNumbersCountException(lottoNumbers.size());
        }
    }
}
