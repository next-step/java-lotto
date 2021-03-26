package lotto.step2.controller;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoStore;
import lotto.step2.domain.Lottos;
import lotto.step2.domain.WinningStatistics;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

public class LottoController {
    public void run(){
        Lottos lottos = LottoStore.purchase(InputView.enterPurchasingAmount());
        ResultView.printLottoNumbers(lottos);
        Lotto winningLotto = InputView.enterWinningNumber();
        WinningStatistics winningStatistics = new WinningStatistics(lottos, winningLotto);
        ResultView.printResult(winningStatistics);
    }
}
