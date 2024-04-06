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
        SelfIssueCount count = getManualIssueCount();

        budget = budget.spend(Price.LOTTO, count);

        Lottos manualLottos = getManualIssuedLottos(count);
        Lottos autoLottos = getAutoIssuedLottos(budget);

        ResultView.showLottoQuantity(manualLottos, autoLottos);

        Lottos allLottos = manualLottos.combine(autoLottos);
        ResultView.showGeneratedLottos(allLottos);

        return allLottos;
    }

    private SelfIssueCount getManualIssueCount() {
        return InputView.retryableInputSelfIssueCount();
    }

    private Lottos getManualIssuedLottos(SelfIssueCount count) {
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
