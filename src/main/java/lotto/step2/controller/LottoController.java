package lotto.step2.controller;

import lotto.step2.domain.*;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

public class LottoController {
    public void run() {
        Lottos lottos = LottoStore.purchase(new Money(InputView.enterPurchasingAmount()));
        ResultView.printLottoNumbers(lottos);
        Lotto winningLotto = new Lotto(InputView.enterWinningNumbers());
        ResultView.printResult(new WinningStatistics(lottos, winningLotto));
    }
}
