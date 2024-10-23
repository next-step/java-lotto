package lotto.controller;

import lotto.domain.Lotteries;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningLottery;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Set;

public class LottoController {
    public static void purchaseAutoLotto() {
        int totalPurchaseAmount = InputView.inputTotalPurchaseAmount();
        Lotteries lotteries = Lotteries.purchase(totalPurchaseAmount);
        ResultView.printPurchasedLottoNumberList(lotteries);

        Set<Integer> inputWinningNumbers = InputView.inputLastWeekWinningNumbers();
        int inputBonusNumber = InputView.inputBonusNumber();
        WinningLottery winningLottery = new WinningLottery(inputWinningNumbers, inputBonusNumber);

        LottoStatistics lottoStatistics = lotteries.createStatistics(winningLottery);
        float profitRate = lottoStatistics.calculateProfitRate(totalPurchaseAmount);
        ResultView.printResult(lottoStatistics, profitRate);
    }
}
