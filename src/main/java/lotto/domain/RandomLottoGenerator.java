package lotto.domain;

import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        return LottoNumber.getRandomLotto(LOTTO_NUMBER_COUNT);
    }
}
