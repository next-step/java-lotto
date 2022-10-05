package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLotto;
import lotto.dto.WinningLottoDto;
import lotto.view.LottoResult;
import lotto.view.LottoStatisticsResult;

public class LottoStore {
    public LottoResult buyLotto(int money) {
        return LottoResult.of(LottoMachine.createPerPrice(money));
    }

    public LottoStatisticsResult createStatistics(LottoResult result, WinningLottoDto winningLottoDto) {
        WinningLotto winningLotto = WinningLotto.from(winningLottoDto);

        LottoStatistics statistics = new LottoStatistics(result.lottos(), winningLotto);

        return new LottoStatisticsResult(statistics);
    }
}
