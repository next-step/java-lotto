package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public void start() {
        Money money = Money.of(InputView.inputMoney());
        Lottos lottos = Lottos.of(money);
        ResultView.printPurchase(lottos);

        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        LottoResult result = LottoResult.of(lottos, winningLotto);
        ResultView.printWinningResult(result);
        ResultView.printEarningRate(money, result);
    }
}
