package lotto.view;

import lotto.code.MatchedNumber;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String BUY_COMPLETED_TEXT = "%s개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TEXT = "당첨 통계";
    private static final String BAR = "---------";
    private static final String WINNING_COUNT_TEXT = "%s개 일치 (%s원)- %s개";
    private static final String TOTAL_ROR_TEXT = "총 수익률은 %s입니다.%s";
    private static final String TOTAL_ROR_LOSS_TEXT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String EMPTY = "";

    public static void printBuyCompleted(String count) {
        System.out.println(String.format(BUY_COMPLETED_TEXT, count));
    }

    public static void printLottoList(List<List<Integer>> lottoList) {
        for (List<Integer> lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static void printResult(Map<Integer, Integer> winningStatistics, int amount) {
        System.out.println(WINNING_STATISTICS_TEXT);
        System.out.println(BAR);
        BigDecimal ror = getRateOfReturn(amount, getTotalWinningAmount(winningStatistics));
        System.out.println(String.format(TOTAL_ROR_TEXT, ror, getTotalRorLossText(ror)));
    }

    static int getTotalWinningAmount(Map<Integer, Integer> winningStatistics) {
        int totalWinningAmount = 0;
        for (Integer matchedNumber : winningStatistics.keySet()) {
            MatchedNumber matchedNumberCode = MatchedNumber.findByNumber(matchedNumber);
            int winningCount = winningStatistics.get(matchedNumber);
            System.out.println(String.format(WINNING_COUNT_TEXT, matchedNumber, matchedNumberCode.getAmount(), winningCount));
            totalWinningAmount += matchedNumberCode.getAmount() * winningCount;
        }
        return totalWinningAmount;
    }

    static BigDecimal getRateOfReturn(int amount, int winningAmount) {
        return BigDecimal.valueOf(winningAmount).divide(BigDecimal.valueOf(amount));
    }

    static String getTotalRorLossText(BigDecimal ror) {
        if (ror.intValue() < 1) return TOTAL_ROR_LOSS_TEXT;
        return EMPTY;
    }

}
