package lotto.step2.controller;

import lotto.step2.domain.*;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

public class LottoController {
    public void run() {
        Money money = new Money(InputView.enterPurchasingAmount());
        Lottos lottos = LottoStore.purchase();
        ResultView.printLottoNumbers(lottos);
        WinningNumbers winningNumbers = new WinningNumbers(InputView.enterWinningNumbers(), InputView.enterBonusNumber());
        ResultView.printResult(new WinningStatistics(lottos, winningNumbers));
    }
}
