package lotto.utils;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.Numbers;

public interface LottoGenerator {

    BasicLotto generate();

    BasicLotto generate(Numbers numbers);
}
