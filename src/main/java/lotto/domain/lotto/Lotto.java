package lotto.domain.lotto;

import lotto.constants.LottoConstants;
import lotto.domain.lotto.strategy.GenerateStrategy;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    private Lotto(GenerateStrategy strategy) {
        this.lottoNumbers = LottoNumbers.of(strategy.generate());
    }



    public static Lotto from(GenerateStrategy strategy) {
        return new Lotto(strategy);
    }
}
