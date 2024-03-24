package lotto.controller;

import lotto.domain.Budget;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void buyLotto() {
        Budget budget = InputView.inputBuyBudget();
        Lottos lottos = new Lottos(budget);
        ResultView.showGeneratedLottos(lottos);
        ResultView.showStatistic(lottos.computeStatistic(InputView.inputLastWinLotto()));
    }

}
