package lotto.application.strategy;

import lotto.domain.Lottos;

@FunctionalInterface
public interface LottoNumberGenerator {
    Lottos generate(int generateCount);

}
