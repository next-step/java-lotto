package lotto;

import lotto.domain.LotteryGames;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class lotteryMain {
    private static final int EACH_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LotteryGames purchasedLottery = new LotteryGames().create(purchaseAmount);
        ResultView.print(purchasedLottery);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();

        Map<Integer, Integer> results = WinningResult.get(winningNumbers, purchasedLottery);
        ResultView.printResult(results);

        double profitRate = WinningResult.profitRate(WinningResult.profit(results), purchaseAmount * EACH_PRICE);
        ResultView.printProfit(profitRate);
    }
}
