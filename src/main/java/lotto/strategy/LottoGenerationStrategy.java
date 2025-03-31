package lotto.strategy;

import java.util.List;

import lotto.domain.Lotto;

public interface LottoGenerationStrategy {
    List<Lotto> generateLottos();
}
