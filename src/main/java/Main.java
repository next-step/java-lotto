import step2.lottery.LotteryCount;
import step2.lottery.Lotterys;
import step2.winning.LotteryMatcher;
import step2.winning.PrizeWinningNumber;
import step2.winning.WinningResults;
import step2.generate.RandomGenerate;
import step2.generate.Generate;
import step2.util.InputView;
import step2.util.OutputView;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LotteryCount lotteryCount = new LotteryCount(purchaseAmount);
        OutputView.printPurchaseAmount(lotteryCount.getLottoCount());

        Generate randomShuffle = new RandomGenerate();
        Lotterys lotterys = new Lotterys(lotteryCount.getLottoCount(), randomShuffle);

        OutputView.printLotteryNumbers(lotterys);

        String winningNumber = InputView.inputWinningNumber();
        int bonusBall = InputView.inputBonusBall();
        PrizeWinningNumber prizeWinningNumber = new PrizeWinningNumber(winningNumber, bonusBall);
        WinningResults result = LotteryMatcher.match(prizeWinningNumber, lotterys);

        OutputView.printWinningStatistics(result);
        OutputView.printTotalPrize(result.calculatePrize(), purchaseAmount);
    }
}