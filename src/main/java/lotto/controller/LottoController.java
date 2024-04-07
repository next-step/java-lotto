package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public void simulateLotto() {
        ResultView.showStatistic(getStatistics());
    }

    private Statistics getStatistics() {
        return getLottos(getBudget()).computeStatistic(getWinLotto());
    }

    private WinLotto getWinLotto() {
        return InputView.retryableInputLastWinLotto();
    }

    private Lottos getLottos(Budget budget) {
        Count manualIssueCount = getManualIssueCount(budget);

        budget = budget.spend(Price.LOTTO, manualIssueCount);

        Lottos manualLottos = getManualIssuedLottos(manualIssueCount);
        Lottos autoLottos = getAutoIssuedLottos(budget);

        ResultView.showLottoQuantity(manualLottos, autoLottos);

        Lottos allLottos = manualLottos.combine(autoLottos);
        ResultView.showGeneratedLottos(allLottos);

        return allLottos;
    }

    private Count getManualIssueCount(Budget budget) {
        return InputView.retryableInputSelfIssueCount(budget);
    }

    private Lottos getManualIssuedLottos(Count count) {
        return InputView.inputSelfIssueLottos(count);
    }
    private Lottos getAutoIssuedLottos(Budget budget) {
        Lottos lottos = new Lottos(budget);
        return lottos;
    }

    private Budget getBudget() {
        Budget budget = InputView.retryableInputBuyBudget();
        return budget;
    }

}
