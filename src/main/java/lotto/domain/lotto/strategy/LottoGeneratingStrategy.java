package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;

@FunctionalInterface
public interface LottoGeneratingStrategy {
    Lotto lotto();
}
