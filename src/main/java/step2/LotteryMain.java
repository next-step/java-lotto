package step2;

import step2.controller.LotteryController;
import step2.domain.Lotteries;
import step2.domain.Statistics;
import step2.view.InputView;
import step2.view.ResultView;

public class LotteryMain {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        LotteryController lotteryController = new LotteryController();

        Lotteries lotteries = lotteryController.getLotteries(purchaseAmount);
        ResultView.printLotteries(lotteries);

        Statistics statisticResult = lotteryController.getStatistics(lotteries, InputView.getWinningNumbers(), InputView.getBonusBallNumber());
        ResultView.printStatistics(statisticResult);
        ResultView.printProfitRate(lotteryController.getProfitRate(statisticResult, purchaseAmount));
    }
}
