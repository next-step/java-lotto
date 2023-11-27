package auto.view;

import auto.application.AutoService;
import auto.application.MatchedAmount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String WINNING_COUNT_MESSAGE = "%s개 일치 (%s원)- %s개";

    public static void printLotteryCounts(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printTotalLotteryNumbers(List<List<Integer>> totalLotteryNumbers) {
        totalLotteryNumbers.forEach(System.out::println);
    }

    public static void printLotteryStats(Map<Integer, Integer> matchedCountMap, int amount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        int totalAmount = getTotalAmountAndPrintMatchedText(matchedCountMap);
        BigDecimal returnRate = AutoService.getReturnRate(totalAmount, amount);
        System.out.println(getTotalReturnRateMessage(returnRate));
    }

    private static String getTotalReturnRateMessage(BigDecimal returnRate) {
        String totalReturnRateMessage = String.format("총 수익률은 %s입니다.", returnRate);
        if (returnRate.intValue() < 1) return totalReturnRateMessage + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        return totalReturnRateMessage;
    }

    public static int getTotalAmountAndPrintMatchedText(Map<Integer, Integer> matchedCountMap) {
        int totalAmount = 0;
        for (Integer matchedCount : matchedCountMap.keySet()) {
            MatchedAmount matchedAmount = MatchedAmount.findByCount(matchedCount);
            int winningCount = matchedCountMap.get(matchedCount);
            printMatchedCountText(matchedCount, matchedAmount, winningCount);
            totalAmount += matchedAmount.getAmount() * winningCount;
        }
        return totalAmount;
    }

    private static void printMatchedCountText(Integer matchedCount, MatchedAmount matchedAmount, int winningCount) {
        System.out.println(String.format(WINNING_COUNT_MESSAGE,
                                         matchedCount,
                                         matchedAmount.getAmount(),
                                         winningCount));
    }
}
