package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public void start() {
        final Money money = Money.of(InputView.inputMoney());
        final LottoStore lottoStore = LottoStore.of(money);
        final Lottos lottos = lottoStore.issueLotto();
        ResultView.displayLottoCount(lottos.size());
        ResultView.displayLottos(lottos);

        final WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningLotto(), InputView.inputBonusNumber());
        final Rankings rankings = Rankings.of(lottos.matchesWinningLotto(winningLotto));
        ResultView.displayLottoResult(rankings);
    }
}
