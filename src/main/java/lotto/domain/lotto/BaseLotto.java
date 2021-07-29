package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;

import java.util.List;

public abstract class BaseLotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    protected final List<LottoNumber> lottoNumbers;

    protected BaseLotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
