package lotto.generator;

import lotto.model.Lotto;

@FunctionalInterface
public interface LottoGeneratorStrategy {
    Lotto lottoGenerator();
}
