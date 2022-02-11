package lotto.domain.lottogenerator;

import lotto.domain.lotto.Lotto;

@FunctionalInterface
public interface LottoGenerator {

    Lotto generateLotto();
}
