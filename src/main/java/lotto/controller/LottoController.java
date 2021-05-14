package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public void start() {
        int inputMoney = InputView.inputMoney();
        int inputManualCounts = InputView.inputManualLottoCount();
        Money money = Money.of(inputMoney, inputManualCounts);
        List<List<Integer>> manualNumbersList = InputView.inputManualLottoNumbers(inputManualCounts);

        Lottos lottos = LottoMachine.createLottos(manualNumbersList, money);

        ResultView.printPurchase(lottos, inputManualCounts);

        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
        LottoResult result = LottoResult.of(lottos, winningLotto);
        ResultView.printWinningResult(result);
        ResultView.printEarningRate(money, result);
    }
}
