package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameController {
    public static void start() {
        int inputMoney = InputView.getMoney();

        Lottos lottos = Lottos.buyLottos(inputMoney);
        ResultView.printLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(InputView.getWinningNumbers(), InputView.getBonusNumber());

        LottoResults results = lottos.getResults(winningLotto);

        ResultView.printResults(results);
        ResultView.printYield(results.calculateYield(inputMoney));
    }
}
