package lotto.strategy;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberPool;

import java.util.List;

public class LottoNumbersRandomStrategy implements LottoNumbersStrategy {

    @Override
    public List<LottoNumber> generate() {
        return LottoNumberPool.getLottoNumbers();
    }
}
