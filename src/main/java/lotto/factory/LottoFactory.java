package lotto.factory;

import lotto.domain.Lotto;
import lotto.strategy.LottoNumbersStrategy;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lotto make(final LottoNumbersStrategy lottoNumbersStrategy) {
        return new Lotto(lottoNumbersStrategy.generate());
    }
}
