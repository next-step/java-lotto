package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        Money purchaseAmount = new Money(InputView.readPurchaseAmountInput());
        Count manualCount = new Count(InputView.readManualLottoCountInput());

        Lottos lottos = buyLottos(purchaseAmount, manualCount);

        Count autoCount = purchaseAmount.countBuyableLottoTickets().subtract(manualCount);
        OutputView.printPurchaseCount(manualCount, autoCount);
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

    private Lottos buyLottos(Money money, Count manual) {
        List<String> manualInputs = InputView.readMaualLottoInput(manual.value());
        LottosBundleGenerator lottosGenerator = new LottosBundleGenerator(money, manualInputs);
        return lottosGenerator.generate();
    }
}
