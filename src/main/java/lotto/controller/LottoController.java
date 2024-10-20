package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void purchaseAutoLotto() {
        int totalPurchaseAmount = InputView.inputTotalPurchaseAmount();
        Lotteries purchasedLottoNumbersList = Lotteries.purchase(totalPurchaseAmount);
        ResultView.printPurchasedLottoNumberList(purchasedLottoNumbersList);

        String inputLastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers();
        Lottery winningNumbers = Lottery.from(inputLastWeekWinningNumbers);

        List<Integer> equalNumberCountList = purchasedLottoNumbersList.getWinningNumberCountList(winningNumbers);
        LottoStatistics lottoStatistics = Lotto.createStatistics(equalNumberCountList);
        float profitRate = ProfitCalculator.calculateProfitRate(totalPurchaseAmount, equalNumberCountList);
        ResultView.printResult(lottoStatistics, profitRate);
    }
}
