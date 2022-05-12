package lotto;

import lotto.domain.LotteryGames;
import lotto.domain.WinningNumbers;
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

        Map<Integer, Integer> results = WinningResult.get(winningNumbers.getWinningNumbers(), purchasedLottery);
        ResultView.printResult(results);

        double profitRate = WinningResult.profitRate(WinningResult.profit(results), purchaseAmount * EACH_PRICE);
        ResultView.printProfit(profitRate);
    }
}
