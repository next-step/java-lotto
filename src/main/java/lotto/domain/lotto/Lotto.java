package lotto.domain.lotto;

import lotto.domain.lottonumber.LottoNumberSet;

public class Lotto {

    protected final LottoNumberSet lottoNumbers;

    public Lotto() {
        this(LottoNumberSet.createLottoNumberSet());
    }

    public Lotto(final LottoNumberSet lottoNumberSet) {
        this.lottoNumbers = lottoNumberSet;
    }

    @Override
    public String toString() {
        return String.format("[%s]", lottoNumbers.toString());
    }
}
