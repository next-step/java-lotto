package lottogame.domain.strategy;

import lottogame.domain.lotto.LottoNumbers;

@FunctionalInterface
public interface LottoNumberGenerationStrategy {
    LottoNumbers getNumbers();
}
