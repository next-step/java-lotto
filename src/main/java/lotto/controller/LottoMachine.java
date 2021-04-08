package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMachine {
    public void start() {
        Money money = Money.of(InputView.inputMoney());
        Lottos lottos = Lottos.of(Lottos.exchange(money));
        ResultView.printPurchase(lottos);

        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumbers());
        LottoResult result = LottoResult.of(lottos, winningLotto);
        ResultView.printWinningResult(result);
        ResultView.printEarningRate(money, result);
    }
}
