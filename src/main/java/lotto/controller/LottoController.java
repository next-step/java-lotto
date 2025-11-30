package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Money purchaseAmount = InputView.readPurchaseAmountInput();
        Count manualCount = InputView.readManualLottoCountInput();
        LottoPurchasePlan lottoPurchasePlan = new LottoPurchasePlan(purchaseAmount, manualCount);

        Lottos lottos = buyLottos(lottoPurchasePlan);

        OutputView.printPurchaseCount(lottoPurchasePlan);
        OutputView.printBoughtLottos(lottos);

        WinningLotto winningLotto = InputView.readWinningLottoAndBonusBallInput();
        LottoResults result = lottos.match(winningLotto);
        OutputView.printResults(result, purchaseAmount);
    }

    private Lottos buyLottos(LottoPurchasePlan lottoPurchasePlan) {
        Lottos manuals = InputView.readMaualLottoInput(lottoPurchasePlan.manualCount().value());
        Lottos autos = lottoPurchasePlan.generateAutoLottos();
        return Lottos.of(manuals, autos);
    }
}
