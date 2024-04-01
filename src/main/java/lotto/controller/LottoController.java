package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void simulateLotto() {
        ResultView.showStatistic(getStatistics());
    }

    private Statistics getStatistics() {
        return getLottos().computeStatistic(getWinLotto());
    }

    private WinLotto getWinLotto() {
        return InputView.inputLastWinLotto();
    }

    private Lottos getLottos() {
        Lottos lottos = new Lottos(getBudget());
        ResultView.showGeneratedLottos(lottos);
        return lottos;
    }

    private Budget getBudget() {
        Budget budget = InputView.inputBuyBudget();
        ResultView.showLottoQuantity(budget.purchasableQuantity(Price.LOTTO));
        return budget;
    }

}
