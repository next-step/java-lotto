package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = InputView.readBudgetInput();
        Lotto winningLotto = InputView.readWinningLottoInput();
        LottoNumber bonusNumber = InputView.readBonusNumberInput();

        OutputView.printPurchaseCount(purchaseAmount.countLottoTickets());
        Lottos lottos = purchaseAmount.buyLottos();
        OutputView.printBoughtLottos(lottos);

        LottoResults result = lottos.calculateResults(winningLotto, bonusNumber);
        OutputView.printResults(result, purchaseAmount);
    }
}
