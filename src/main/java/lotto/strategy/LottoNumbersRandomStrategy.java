package lotto.strategy;

import lotto.domain.LottoNumberPool;
import lotto.domain.LottoNumbers;

public class LottoNumbersRandomStrategy implements LottoNumbersStrategy {

    @Override
    public LottoNumbers generate() {
        return new LottoNumbers(LottoNumberPool.getLottoNumbers());
    }
}
