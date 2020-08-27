package lotto.controller;

import lotto.domain.*;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoController {
    public void start() {
        final Money money = Money.of(inputMoney());
        final ManualLotto manualLotto = ManualLotto.of(inputManualLotto());
        final LottoStore lottoStore = LottoStore.of(money, manualLotto);
        final Lottos lottos = lottoStore.issue();
        displayLottoCount(manualLotto.size(), lottos.size());
        displayLottos(lottos);

        final WinningLotto winningLotto = WinningLotto.of(inputWinningLotto(), inputBonusNumber());
        final Rankings rankings = lottos.matchesWinningLotto(winningLotto);
        displayLottoResult(rankings);
    }
}
