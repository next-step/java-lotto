package lotto.domain;

import lotto.domain.strategy.LottoStrategy;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoStrategy lottoStrategy) {
        this.lottoNumbers = new LottoNumbers(lottoStrategy);
    }
}
