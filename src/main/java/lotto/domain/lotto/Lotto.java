package lotto.domain.lotto;

import lotto.domain.lotto.strategy.GenerateStrategy;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    private Lotto(GenerateStrategy strategy) {
        this.lottoNumbers = LottoNumbers.of(strategy.generate());
    }



    public static Lotto of(GenerateStrategy strategy) {
        return new Lotto(strategy);
    }
}
