package step2.service;

import step2.domain.*;
import step2.strategy.NumberGeneratorStrategy;

public class LottoService {
    private static final int MIN_MATCH_COUNT = 3;

    private NumberGeneratorStrategy generatorStrategy;

    private LottoService() {
    }

    public LottoService(NumberGeneratorStrategy generatorStrategy) {
        this.generatorStrategy = generatorStrategy;
    }

    public Lottos purchase(int price) {
        return Lottos.purchase(price, generatorStrategy);
    }

    public WinningResult winningResult(Lottos purchasedLottos, String winningNumbers) {
        WinningLotto winningLotto = WinningLotto.create(winningNumbers);
        return calculate(purchasedLottos, winningLotto);
    }

    private WinningResult calculate(Lottos purchasedLottos, WinningLotto winningLotto) {
        WinningResult winningResult = WinningResult.create();
        for (Lotto lotto : purchasedLottos.getLottos()) {
            int matchCount = lotto.match(winningLotto.getLotto());
            addWinningTypeCount(matchCount, winningResult);
        }
        return winningResult;
    }

    private void addWinningTypeCount(int matchCount, WinningResult winningResult) {
        if (matchCount < MIN_MATCH_COUNT) {
            return;
        }
        WinningType type = WinningType.findBy(matchCount);
        winningResult.addCount(type);
    }
}
