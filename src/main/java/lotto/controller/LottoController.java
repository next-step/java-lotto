package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private static final String RESTART_MESSAGE = "\n[INFO] 로또를 재시작합니다.\n";

    LottoService lottoService = new LottoService();

    public void startLotto() {
        try {
            Money totalPurchaseMoney = new Money(InputView.inputPurchaseAmount());
            int manualLottoCount = InputView.inputManualLottoCount();
            Money randomPurchaseMoney = totalPurchaseMoney.excludeManualPurchase(manualLottoCount);
            List<String> manualLottos = InputView.inputManualLottoList(manualLottoCount);

            lottoService.generateManualLottos(manualLottos);
            Lottos registerLottos = lottoService.generateRandomLottos(new RandomNumberGenerator(), randomPurchaseMoney);
            ResultView.printPurchaseMessage(registerLottos, manualLottoCount, randomPurchaseMoney.purchaseCount());

            String lastWeekWinningNumber = InputView.inputLastWeekWinningNumber();
            String bonusNumber = InputView.inputLastWeekBonusNumber();

            RankingResult rankingResult = lottoService.registerWinningNumbers(lastWeekWinningNumber, bonusNumber);
            ResultView.printWinningMessage(rankingResult, rankingResult.calculateProfit().profitRate(totalPurchaseMoney));
        } catch (IllegalArgumentException e) {
            System.out.println("\n" + e.getMessage() + RESTART_MESSAGE);
            startLotto();
        }
    }
}
