package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.strategy.LottoGenerationStrategy;

public class LottoFactoryService {
    private final LottoGenerationStrategy strategy;

    public LottoFactoryService(LottoGenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateLottoNumbers(strategy)));
        }

        return lottos;
    }

    private static List<Integer> generateLottoNumbers(LottoGenerationStrategy strategy) {
        return strategy.generate();
    }
}
