package step2;

import step2.controller.LotteryController;
import step2.domain.Lotteries;
import step2.domain.enums.RANKING;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Map;

public class LotteryMain {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        
        LotteryController lotteryController = new LotteryController();
        Lotteries lotteries = lotteryController.getLotteries(purchaseAmount / 1000);
        ResultView.printLotteries(lotteries);

        Map<RANKING, Integer> statisticResult = lotteryController.process(lotteries, InputView.inputLotteryNumbers());
        ResultView.printResult(statisticResult);

        int profitAmount = lotteryController.calculateProfitAmount(statisticResult);
        double rate = lotteryController.calculateProfitRate(purchaseAmount, profitAmount);
        ResultView.printStatisticRate(rate);
    }
}
