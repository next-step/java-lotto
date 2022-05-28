package lotto;

import lotto.domain.LotteryGames;
import lotto.domain.WinningNumbers;
import lotto.domain.Rank;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LotteryMain {
    private static final int EACH_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LotteryGames purchasedLottery = new LotteryGames(purchaseAmount);
        ResultView.print(purchasedLottery);

        String winNumbers = InputView.inputWinningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(winNumbers);
        int bonusNumber = InputView.inputBonusNumber();

        WinningResult winningResult = new WinningResult(winningNumbers, bonusNumber, purchasedLottery);
        Map<Rank, Integer> results = winningResult.get();
        ResultView.printResult(results);

        double profitRate = winningResult.profitRate(winningResult.profit(results), purchaseAmount * EACH_PRICE);
        ResultView.printProfit(profitRate);
    }
}
