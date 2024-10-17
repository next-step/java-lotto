package lotto.strategy;

import lotto.domain.Lotto;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {
    List<Lotto> generate(final int count);
}
