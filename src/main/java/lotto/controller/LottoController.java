package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private static final int EACH_PRICE = 1000;
    LottoService lottoService = new LottoService();

    public void startLotto() {
        int purchasePrice = InputView.inputPurchaseAmount();
        Money purchaseMoney = new Money(purchasePrice - purchasePrice % EACH_PRICE);

        Lottos registerLottos = lottoService.generateRandomLottos(new RandomNumberGenerator(), purchasePrice, EACH_PRICE);
        ResultView.printPurchaseMessage(registerLottos, purchasePrice / EACH_PRICE);

        String lastWeekWinningNumber = InputView.inputLastWeekWinningNumber();
        String bonusNumber = InputView.inputLastWeekBonusNumber();
        RankingResult rankingResult = lottoService.registerWinningNumbers(lastWeekWinningNumber, bonusNumber);
        ResultView.printWinningMessage(rankingResult, rankingResult.calculateProfit()
                .profitRate(purchaseMoney));
    }
}
