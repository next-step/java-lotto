package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotteries;
import lotto.domain.Lottery;
import lotto.domain.LottoStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

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

        LottoStatistics lottoStatistics = lotteries.createStatistics(winningLottery, bonusNumber);
        float profitRate = lottoStatistics.calculateProfitRate(totalPurchaseAmount);
        ResultView.printResult(lottoStatistics, profitRate);
    }
}
