package auto.view;

import auto.application.AutoLottoService;
import auto.application.MatchedAmount;
import auto.domain.Lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String WINNING_COUNT_MESSAGE = "%s개 일치%s(%s원)- %s개";
    private static final String BONUS_BALL_TEXT = ", 보너스 볼 일치";

    public static void printLottoCounts(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printTotalLottoNumbers(List<List<Integer>> totalLottoNumbers) {
        totalLottoNumbers.forEach(System.out::println);
    }

    public static void printLottoStats(Map<MatchedAmount, Integer> matchedCountMap, int amount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        int totalAmount = getTotalAmountAndPrintMatchedText(matchedCountMap);
        BigDecimal returnRate = AutoLottoService.getReturnRate(totalAmount, amount);
        System.out.println(getTotalReturnRateMessage(returnRate));
    }

    private static String getTotalReturnRateMessage(BigDecimal returnRate) {
        String totalReturnRateMessage = String.format("총 수익률은 %s입니다.", returnRate);
        if (returnRate.intValue() < 1) return totalReturnRateMessage + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        return totalReturnRateMessage;
    }

    public static int getTotalAmountAndPrintMatchedText(Map<MatchedAmount, Integer> matchedCountMap) {
        int totalAmount = 0;
        for (MatchedAmount matchedAmount : matchedCountMap.keySet()) {
            int winningCount = matchedCountMap.get(matchedAmount);
            System.out.println(String.format(WINNING_COUNT_MESSAGE,
                                             matchedAmount.getCount(),
                                             getBonusBallText(matchedAmount),
                                             matchedAmount.getAmount(),
                                             winningCount));

            totalAmount += matchedAmount.getAmount() * winningCount;
        }
        return totalAmount;
    }

    static String getBonusBallText(MatchedAmount matchedAmount) {
        return MatchedAmount.isMatchedNumberFiveAndBonus(matchedAmount) ? BONUS_BALL_TEXT : " ";
    }
}
