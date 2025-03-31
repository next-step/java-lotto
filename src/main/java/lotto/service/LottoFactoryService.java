package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.strategy.LottoGenerationStrategy;

public class LottoFactoryService {
    private final LottoGenerationStrategy strategy;

    public LottoFactoryService(LottoGenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Lotto> generateLottos() {
        return strategy.generateLottos();
    }
}
