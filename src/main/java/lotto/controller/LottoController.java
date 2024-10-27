package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class LottoController {
    public static void purchaseAutoLotto() {
        int totalPurchaseAmount = InputView.inputTotalPurchaseAmount();
        int manualLottoAmount = InputView.inputManualLottoAmount();
        LotteryBuyer lotteryBuyer = LotteryBuyer.of(totalPurchaseAmount, manualLottoAmount);

        List<Lottery> manualLottoNumbers = InputView.inputAndParseManualLotteries(manualLottoAmount);
        Lotteries lotteries = lotteryBuyer.purchaseLotteries(manualLottoNumbers);
        ResultView.printPurchasedLottoNumberList(lotteries, manualLottoNumbers.size());

        Set<Integer> inputWinningNumbers = InputView.inputLastWeekWinningNumbers();
        int inputBonusNumber = InputView.inputBonusNumber();
        WinningLottery winningLottery = new WinningLottery(inputWinningNumbers, inputBonusNumber);

        LottoStatistics lottoStatistics = lotteries.createStatistics(winningLottery);
        float profitRate = lottoStatistics.calculateProfitRate(totalPurchaseAmount);
        ResultView.printResult(lottoStatistics, profitRate);
    }
}
