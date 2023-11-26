package lotto.controller;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;
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
        List<Lotto> manualLottos = LottoMachine.issueManualLottos(InputView.inputManualNumbers(manualQuantity));

        final int autoQuantity = quantity - manualQuantity;
        List<Lotto> autoLottos = LottoMachine.issueAutoLottos(autoQuantity);

        OutputView.outputQuantity(manualQuantity, autoQuantity);
        List<Lotto> lottos = LottoMachine.addAllLottos(manualLottos, autoLottos);
        OutputView.outputLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers(DELIMITER);
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        LottoWinningMachine winningMachine = new LottoWinningMachine(new Lotto(winningNumbers), bonusNumber);
        Map<Rank, Integer> rankCounts = winningMachine.getRankCounts(lottos);

        OutputView.outputWinningResult(rankCounts);
        OutputView.outputRateOfResult(winningMachine.calculateRateOfResult(rankCounts, amount));
    }
}
