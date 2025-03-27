import step2.LotteryCount;
import step2.Lotterys;
import step2.WinningResults;
import step2.shuffle.RandomShuffle;
import step2.shuffle.Shuffle;
import step2.util.InputView;
import step2.util.OutputView;

public class Main {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();

        LotteryCount lotteryCount = new LotteryCount(purchaseAmount);
        OutputView.printPurchaseAmount(lotteryCount.getLottoCount());

        Shuffle randomShuffle = new RandomShuffle();
        Lotterys lotterys = new Lotterys(lotteryCount.getLottoCount(), randomShuffle);

        OutputView.printLotteryNumbers(lotterys);

        String winningNumber = InputView.inputWinningNumber();
        WinningResults result = lotterys.prizeWinning(winningNumber);

        OutputView.printWinningStatistics(result);
        OutputView.printTotalPrize(result.calculatePrize(), purchaseAmount);
    }
}