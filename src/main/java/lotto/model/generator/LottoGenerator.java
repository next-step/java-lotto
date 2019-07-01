package lotto.model.generator;

import lotto.model.Lotto;

import java.util.List;

@FunctionalInterface
public interface LottoGenerator {

    List<Lotto> generator();
}
