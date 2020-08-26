package lotto.controller;

import lotto.domain.*;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoController {
    public void start() {
        final Money money = Money.of(inputMoney());
        final LottoCount lottoCount = LottoCount.of(inputManualCount());
        final LottoStore lottoStore = LottoStore.of(money, lottoCount);
        final Lottos lottos = lottoStore.issueLotto(ManualLottoGenerator.of(inputManualNumber(lottoCount)));
        displayLottoCount(lottoCount, money);
        displayLottos(lottos);

        final WinningLotto winningLotto = WinningLotto.of(inputWinningLotto(), inputBonusNumber());
        final Rankings rankings = Rankings.of(lottos.matchesWinningLotto(winningLotto));
        displayLottoResult(rankings);
    }
}
