package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        Money purchasedAmount = InputView.acceptPuchaseAmount();
        Lottos purchasedLottos = Lottos.create(purchasedAmount.getLottoCount());
        ResultView.printInput(purchasedLottos, purchasedAmount);
        WinningLotto winningLotto = InputView.acceptWinningLotto();

        Result result = purchasedLottos.makeResult(winningLotto);

        ResultView.printResult(purchasedAmount, result);
    }
}
