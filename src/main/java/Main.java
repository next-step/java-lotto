import step2.lottery.Lottery;
import step2.lottery.LotteryCount;
import step2.lottery.Lotterys;
import step2.winning.PrizeWinningNumber;
import step2.winning.WinningResults;
import step2.generate.RandomGenerate;
import step2.generate.Generate;
import step2.util.InputView;
import step2.util.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        int manualCount = InputView.inputManualCount();
        List<Lottery> manualLotteries = new ArrayList<>();
        InputView.inputManualNumbers();
        for (int i = 0; i < manualCount; i++) {
            String input = InputView.inputManualNumber();
            manualLotteries.add(new Lottery(input));
        }

        LotteryCount lotteryCount = new LotteryCount(purchaseAmount, manualCount);
        OutputView.printPurchaseAmount(manualCount, lotteryCount.getAutoLottoCount());

        Generate randomShuffle = new RandomGenerate();
        Lotterys lotterys = new Lotterys(manualLotteries, lotteryCount.getAutoLottoCount(), randomShuffle);

        OutputView.printLotteryNumbers(lotterys);

        String winningNumber = InputView.inputWinningNumber();
        int bonusBall = InputView.inputBonusBall();
        PrizeWinningNumber prizeWinningNumber = new PrizeWinningNumber(winningNumber, bonusBall);
        WinningResults result = lotterys.countWinningResults(prizeWinningNumber);

        OutputView.printWinningStatistics(result);
        OutputView.printTotalPrize(result.calculatePrize(), purchaseAmount);
    }
}