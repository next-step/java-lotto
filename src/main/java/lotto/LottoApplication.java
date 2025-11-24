package lotto;

import lotto.model.PurchaseAmount;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = InputView.readBudgetInput();
        Lotto winningLotto = InputView.readWinningLottoInput();

        OutputView.printPurchaseCount(purchaseAmount.countLottoTickets());
        Lottos lottos = purchaseAmount.buyLottos();
        OutputView.printBoughtLottos(lottos);

        LottoResults result = lottos.calculateResults(winningLotto);
        OutputView.printResults(result, purchaseAmount);
    }
}
