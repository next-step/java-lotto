package lotto;

import lotto.domain.*;
import lotto.interfaces.LotteryGame;
import lotto.interfaces.LotteryResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LotteryMain {
    public static void main(String[] args) {
        int purchasePrice = InputView.inputPurchaseAmount();
        int manualLotteryAmount = InputView.inputPurchaseManualLotteryAmount();

        InputView.inputManualLotteryAmount();
        List<LotteryGame> manualLotteryGames = new ArrayList<>();
        for (int i = 0; i < manualLotteryAmount; i++) {
            manualLotteryGames.add(new ManualLotteryGame(InputView.inputManualLottery()));
        }

        InputView.printPurchaseAmount(purchasePrice, manualLotteryAmount);
        LotteryGames purchasedLottery = new LotteryGames(purchasePrice, manualLotteryGames);
        ResultView.print(purchasedLottery);

        String winNumbers = InputView.inputWinningNumbers();
        String bonusNumber = InputView.inputBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winNumbers, bonusNumber);

        LotteryResult lotteryResult = new WinningResults(purchasedLottery, winningNumbers);
        Map<Rank, Integer> results = lotteryResult.result();
        ResultView.printResult(results);

        double profitRate = lotteryResult.profit(results, purchasePrice);
        ResultView.printProfit(profitRate);
    }
}
