package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.Map;

public class LottoController {

    private static final String DELIMITER = ", ";

    private LottoController() {
    }

    public static void run() {
        final int amount = InputView.inputAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        final int quantity = purchaseAmount.calculateLottoQuantity();

        final int manualQuantity = InputView.inputManualQuantity();
        final int autoQuantity = quantity - manualQuantity;
        OutputView.outputQuantity(manualQuantity, autoQuantity);

        Lottos manualLottos = LottoMachine.issueManualLottos(InputView.inputManualNumbers(manualQuantity));
        Lottos autoLottos = LottoMachine.issueAutoLottos(autoQuantity);
        Lottos lottos = new Lottos(manualLottos, autoLottos);
        OutputView.outputLottos(lottos);

        Lotto winningLotto = new Lotto(InputView.inputWinningNumbers(DELIMITER));
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        LottoWinningMachine winningMachine = new LottoWinningMachine(winningLotto, bonusNumber);
        Map<Rank, Integer> rankCounts = winningMachine.getRankCounts(lottos);
        OutputView.outputWinningResult(rankCounts);
        OutputView.outputRateOfResult(winningMachine.calculateRateOfResult(rankCounts, amount));
    }
}
