package lotto.domain.lottoStrategy;

import lotto.domain.Lotto;

@FunctionalInterface
public interface LottoGenerateStrategy {

    Lotto generateLotto(int count);
}

