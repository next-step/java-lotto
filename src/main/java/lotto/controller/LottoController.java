package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class LottoController {
    public static void purchaseAutoLotto() {
        int totalPurchaseAmount = InputView.inputTotalPurchaseAmount();
        Lotteries lotteries = Lotteries.purchase(totalPurchaseAmount);
        ResultView.printPurchasedLottoNumberList(lotteries);

        Set<Integer> inputWinningNumbers = InputView.inputLastWeekWinningNumbers();
        Lottery winningLottery = new Lottery(inputWinningNumbers);

        Integer inputBonusNumber = InputView.inputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);

        List<LottoResult> lottoResults = lotteries.getLottoResults(winningLottery, bonusNumber);
        LottoStatistics lottoStatistics = LottoStatistics.create(lottoResults);
        float profitRate = lottoStatistics.calculateProfitRate(totalPurchaseAmount);
        ResultView.printResult(lottoStatistics, profitRate);
    }
}
