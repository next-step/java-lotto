package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public void start() {
        int inputMoney = InputView.inputMoney();
        int inputManualCount = InputView.inputManualLottoCount();
        Money money = Money.of(inputMoney, inputManualCount);
        List<List<Integer>> manualNumbersList = InputView.inputManualLottoNumbers(inputManualCount);

        Lottos lottos = LottoMachine.createLottos(manualNumbersList, money);

        ResultView.printPurchase(lottos, inputManualCount);

        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        LottoResult result = LottoResult.of(lottos, winningLotto);
        ResultView.printWinningResult(result);
        ResultView.printEarningRate(money, result);
    }
}
