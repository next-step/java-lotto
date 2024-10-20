package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotteries;
import lotto.domain.Lottery;
import lotto.domain.LottoStatistics;
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

        Integer inputBonusNumber = InputView.inputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);

        List<Integer> winningNumberCountList = purchasedLottoNumbersList.getWinningNumberCountList(winningNumbers);
        LottoStatistics lottoStatistics = LottoStatistics.create(winningNumberCountList);
        float profitRate = lottoStatistics.calculateProfitRate(totalPurchaseAmount);
        ResultView.printResult(lottoStatistics, profitRate);
    }
}
