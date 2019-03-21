package lotto.utils;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.Numbers;

public class ManualLottoGenerator implements LottoGenerator {

    @Override
    public BasicLotto generate() {
        return new BasicLotto(new Numbers(null));
    }

    @Override
    public BasicLotto generate(Numbers numbers) {
        return new BasicLotto(numbers);
    }
}
