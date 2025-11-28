package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Money purchaseAmount = InputView.readPurchaseAmountInput();
        WinningLotto winningLotto = InputView.readWinningLottoInput();

        OutputView.printPurchaseCount(purchaseAmount.countLottoTickets());
        Lottos lottos = purchaseAmount.buyLottos();
        OutputView.printBoughtLottos(lottos);

        LottoResults result = lottos.match(winningLotto);
        OutputView.printResults(result, purchaseAmount);
    }
}
