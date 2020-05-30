package step2.view;

import step2.LotteryNumbers;
import step2.Statistics;
import step2.WinningStatistics;
import step2.Yield;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private List<LotteryNumbers> lotteryNumbersList = new ArrayList<>();

    private ResultView() {
    }

    public ResultView(List<LotteryNumbers> lotteryNumbersList){
        this.lotteryNumbersList = lotteryNumbersList;
        printMessage(lotteryNumbersList.size() + "개를 구매했습니다.");
        for (LotteryNumbers lotteryNumbers : lotteryNumbersList) {
            printMessage(lotteryNumbers.getLottoNumberList().toString());
        }
    }

    public void printResult(Statistics result) {
        printMessage("당첨 통계");
        printMessage("----------");

        printStatistics(result);

        double yield = Yield.calculate(result.getTotalPrice(), lotteryNumbersList.size() * 1000);
        String message = "총 수익률은 " + yield + "입니다.";
        if (yield < 0) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        printMessage(message);

    }
    private static void printMessage(String message) {
        System.out.println(message);
    }

    private void printStatistics(Statistics result) {
        result.getStatisticsMap().forEach((key, value) -> {
            WinningStatistics winning = WinningStatistics.valueOfWinningCount(key);
            winning.print(value);
        });
    }
}
