package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        Money purchaseAmount = InputView.readPurchaseAmountInput();
        Count manualCount = InputView.readManualLottoCountInput();
        LottoPurchasePlan lottoPurchasePlan = new LottoPurchasePlan(purchaseAmount, manualCount);

        Lottos lottos = buyLottos(lottoPurchasePlan);

        OutputView.printPurchaseCount(lottoPurchasePlan);
        OutputView.printBoughtLottos(lottos);

        WinningLotto winningLotto = readWinningLottoAndBonusBall();
        LottoResults result = lottos.match(winningLotto);
        OutputView.printResults(result, purchaseAmount);
    }

    private WinningLotto readWinningLottoAndBonusBall() {
        String lotto = InputView.readWinningLottoInput();
        int bonusNumber = InputView.readBonusNumberInput();
        return new WinningLotto(lotto, bonusNumber);
    }

    private Lottos buyLottos(LottoPurchasePlan lottoPurchasePlan) {
        List<String> manualInputs = InputView.readMaualLottoInput(lottoPurchasePlan.manualCount().value());
        Lottos manuals = new ManualLottosGenerator(manualInputs).generate();
        Lottos autos = new AutoLottosGenerator(lottoPurchasePlan).generate();
        return Lottos.of(manuals, autos);
    }
}
