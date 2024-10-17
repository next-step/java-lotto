package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.ProfitCalculator;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class LottoController {
    public static void purchaseAutoLotto() {
        int totalPurchaseAmount = InputView.inputTotalPurchaseAmount();
        List<Set<Integer>> purchasedLottoNumbersList = Lotto.purchase(totalPurchaseAmount);
        ResultView.printPurchasedLottoNumberList(purchasedLottoNumbersList);

        String inputLastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers();
        WinningNumbers winningNumbers = WinningNumbers.from(inputLastWeekWinningNumbers);

        List<Integer> equalNumberCountList = winningNumbers.equalNumberCountList(purchasedLottoNumbersList);
        LottoStatistics lottoStatistics = Lotto.createStatistics(equalNumberCountList);
        float profitRate = ProfitCalculator.calculateProfitRate(totalPurchaseAmount, equalNumberCountList);
        ResultView.printResult(lottoStatistics, profitRate);
    }
}
