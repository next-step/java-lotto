package step2.service;

import step2.domain.Number;
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

    public WinningResult winningResult(Lottos purchasedLottos, String winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = WinningLotto.create(winningNumbers);
        return calculate(purchasedLottos, winningLotto, Number.create(bonusNumber));
    }

    private WinningResult calculate(Lottos purchasedLottos, WinningLotto winningLotto, Number bonusNumber) {
        WinningResult winningResult = WinningResult.create();
        for (Lotto lotto : purchasedLottos.getLottos()) {
            int matchCount = lotto.match(winningLotto.getLotto());
            boolean matchBonus = lotto.matchBonus(bonusNumber);
            addWinningTypeCount(matchCount, matchBonus, winningResult);
        }
        return winningResult;
    }

    private void addWinningTypeCount(int matchCount, boolean matchBonus, WinningResult winningResult) {
        if (matchCount < MIN_MATCH_COUNT) {
            return;
        }
        WinningType type = WinningType.findBy(matchCount, matchBonus);
        winningResult.addCount(type);
    }
}
