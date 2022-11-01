package lotto.controller;

import lotto.domain.*;
import lotto.domain.WinningsCalculator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameController {
    public static void start() {
        int inputMoney = InputView.getMoney();

        Lottos lottos = Lottos.buyLottos(inputMoney);
        ResultView.printLottos(lottos);

        Lotto winnings = new Lotto(InputView.getWinningNumbers());

        List<LottoResult> results = lottos.getResults(winnings);

        ResultView.printResults(results);
        ResultView.printYield(WinningsCalculator.calculateYield(inputMoney, WinningsCalculator.calculateWinnings(results)));
    }
}
