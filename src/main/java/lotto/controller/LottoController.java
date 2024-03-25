package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void buyLotto() {
        Budget budget = InputView.inputBuyBudget();
        Lottos lottos = new Lottos(budget);
        ResultView.showGeneratedLottos(lottos);
        Statistics resultStatistics = lottos.computeStatistic(InputView.inputLastWinLotto());
        ResultView.showStatistic(resultStatistics);
    }

}
