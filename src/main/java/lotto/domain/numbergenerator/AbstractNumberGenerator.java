package lotto.domain.numbergenerator;

import lotto.domain.LottoNumber;
import lotto.exception.LottoNumbersCountException;

import java.util.List;

public abstract class AbstractNumberGenerator {
    protected static final int LOTTO_NUMBERS_COUNT = 6;

    protected void validateLottoNumbersCount(int count) {
        if (count != LOTTO_NUMBERS_COUNT) {
            throw new LottoNumbersCountException(count);
        }
    }

    public abstract List<LottoNumber> generate();
}
