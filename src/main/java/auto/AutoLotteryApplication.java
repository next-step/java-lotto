package auto;

import auto.application.AutoLotteryService;
import auto.application.MatchLotteryService;
import auto.view.InputView;
import auto.view.ResultView;

import java.util.List;
import java.util.Map;

public class AutoLotteryApplication {
    private static final AutoLotteryService autoLotteryService = new AutoLotteryService();
    private static final MatchLotteryService matchLotteryService = new MatchLotteryService();

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int lotteryCount = autoLotteryService.getLotteryCount(purchaseAmount);
        ResultView.printLotteryCounts(lotteryCount);

        List<List<Integer>> totalLotteryNumbers = autoLotteryService.createLotteryNumbersList(lotteryCount);
        ResultView.printTotalLotteryNumbers(totalLotteryNumbers);

        List<Integer> winningNumbersLastWeek = InputView.inputWinningNumbersLastWeek();
        Map<Integer, Integer> matchedCountMap = matchLotteryService.getMatchedCountMap(totalLotteryNumbers, winningNumbersLastWeek);
        ResultView.printLotteryStats(matchedCountMap, purchaseAmount);
    }
}
