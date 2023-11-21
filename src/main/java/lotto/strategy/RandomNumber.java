package lotto.strategy;

import static lotto.model.LottoNumberValidate.LOTTO_MAX_RANGE;
import static lotto.model.LottoNumberValidate.LOTTO_MIN_RANGE;

public class RandomNumber implements LottoStrategy{
    @Override
    public int generateNumber() {
        return (int) (Math.random() * LOTTO_MAX_RANGE + LOTTO_MIN_RANGE);
    }
}
