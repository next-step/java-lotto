package auto;

import auto.application.AutoService;
import auto.application.MatchService;
import auto.view.InputView;
import auto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoApplication {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int lotteryCount = purchaseAmount / LOTTO_PRICE;

        ResultView.printLottoCounts(lotteryCount);

        var totalLotteryNumbers = IntStream.range(0, lotteryCount)
                                           .mapToObj(i -> AutoService.createLotteryNumbers())
                                           .collect(Collectors.toCollection(ArrayList::new));
        totalLotteryNumbers.forEach(System.out::println);

        List<Integer> winningNumbersLastWeek = InputView.inputWinningNumbersLastWeek();
        Map<Integer, Integer> matchedCountMap = MatchService.getMatchedCountMap(totalLotteryNumbers, winningNumbersLastWeek);
        
        ResultView.printLotteryStats(matchedCountMap, purchaseAmount);
    }
}
