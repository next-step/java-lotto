package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStatistics;
import lotto.dto.WinningNumber;
import lotto.view.LottoResult;
import lotto.view.LottoStatisticsResult;

public class LottoStore {
    public LottoResult buyLotto(int money) {
        return LottoResult.of(LottoFactory.createPerPrice(money));
    }

    public LottoStatisticsResult createStatistics(LottoResult result, WinningNumber winningNumber) {
        Lotto winLotto = LottoFactory.create(winningNumber.winningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(winningNumber.bonusNumber());

        LottoStatistics statistics = new LottoStatistics(result.lottos(), winLotto, bonusNumber);

        return new LottoStatisticsResult(statistics);
    }
}
