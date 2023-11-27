package auto;

import auto.application.AutoService;
import auto.application.MatchService;
import auto.view.InputView;
import auto.view.ResultView;

import java.util.List;
import java.util.Map;

public class AutoApplication {
    private static final int LOTTERY_PRICE = 1000;
    private static final AutoService autoService = new AutoService();
    private static final MatchService matchService = new MatchService();

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int lotteryCount = purchaseAmount / LOTTERY_PRICE;
        ResultView.printLotteryCounts(lotteryCount);

        List<List<Integer>> totalLotteryNumbers = autoService.createLotteryNumbersList(lotteryCount);
        ResultView.printTotalLotteryNumbers(totalLotteryNumbers);

        List<Integer> winningNumbersLastWeek = InputView.inputWinningNumbersLastWeek();
        Map<Integer, Integer> matchedCountMap = matchService.getMatchedCountMap(totalLotteryNumbers, winningNumbersLastWeek);
        ResultView.printLotteryStats(matchedCountMap, purchaseAmount);
    }
}
