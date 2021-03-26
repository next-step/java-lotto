package step2.domain.Lotto;

import step2.exception.ListNullPointerException;

import java.util.List;

public final class Lotto {
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (isListNull(lottoNumbers)) {
            throw new ListNullPointerException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static final Lotto newInstance(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private final boolean isListNull(List<LottoNumber> lottoNumbers) {
        return lottoNumbers == null;
    }

    public final List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
