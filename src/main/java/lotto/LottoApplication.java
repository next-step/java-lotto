package lotto;

import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Budget budget = InputView.readBudgetInput();
        Lotto winningLotto = InputView.readWinningLottoInput();

        OutputView.printPurchaseCount(budget.countLottoTickets());
        Lottos lottos = budget.buyLottos();
        OutputView.printBoughtLottos(lottos);

        LottoResults result = lottos.calculateResults(winningLotto);
        OutputView.printResults(result, budget);
    }
}
