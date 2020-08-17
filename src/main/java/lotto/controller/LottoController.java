package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public void start() {
        final Money money = Money.of(InputView.inputMoney());
        final Lottos lottos = new LottoStore().issueLotto(money.getLottoCount());
        ResultView.displayLottoCount(money);
        ResultView.displayLottos(lottos);

        final WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningLotto()) ;
        final LottoResult lottoResult = lottos.getResult(winningLotto);
        ResultView.displayLottoResult(lottoResult, money);
    }
}
