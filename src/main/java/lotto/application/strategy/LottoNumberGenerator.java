package lotto.application.strategy;

import lotto.domain.Lotto;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {
    List<Lotto> generate(int generateCount);

}
