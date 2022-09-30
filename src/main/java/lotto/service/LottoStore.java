package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoStatistics;
import lotto.view.LottoResult;
import lotto.view.LottoStatisticsResult;

public class LottoStore {
    public LottoResult buyLotto(int money) {
        return LottoResult.of(LottoFactory.createPerPrice(money));
    }

    public LottoStatisticsResult createStatistics(LottoResult result, String winningNumber) {
        Lotto winLotto = LottoFactory.create(winningNumber);

        LottoStatistics statistics = new LottoStatistics(result.lottos(), winLotto);

        return new LottoStatisticsResult(statistics);
    }
}
