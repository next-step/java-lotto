package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;

@FunctionalInterface
public interface LottoNumberCreateStrategy {
    LottoNumber create();
}
