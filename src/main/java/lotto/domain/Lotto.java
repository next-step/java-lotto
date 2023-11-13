package lotto.domain;

import lotto.strategy.RandomLottoGenerator;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(RandomLottoGenerator randomLottoGenerator) {
        this.lottoNumbers = new LottoNumbers(randomLottoGenerator);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
