package lotto.domain.strategy;

import lotto.domain.model.lotto.LottoNumber;

import java.util.Set;

@FunctionalInterface
public interface LottoNumberGeneratorStrategy {

    Set<LottoNumber> generate();
}
