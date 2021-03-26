package step2.domain.Lotto;

import step2.exception.ListNullPointerException;

import java.util.List;

public final class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        if(isListNull(lottoNumbers)) {
            throw new ListNullPointerException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public final static LottoNumbers newInstance(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    private final boolean isListNull(List<LottoNumber> lottoNumbers) {
        return lottoNumbers == null;
    }
}
