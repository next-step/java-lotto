package lotto.domain;

import lotto.strategy.LottoGenerator;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoNumbers = new LottoNumbers(lottoGenerator);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
