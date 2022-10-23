package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Set;

@FunctionalInterface
public interface LottoGeneratorStrategy {
    Set<LottoNumber> generate();
}
