package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void start() {
        Money purchasedAmount = InputView.acceptPuchaseAmount();
        Lottos purchasedLottos = Lottos.create(purchasedAmount.getLottoCount());
        ResultView.printInput(purchasedLottos, purchasedAmount);
        WinningNumber winningNumber = InputView.acceptWinningNumber();

        Result result = purchasedLottos.makeResult(winningNumber);

        ResultView.printResult(purchasedAmount, result);
    }
}
