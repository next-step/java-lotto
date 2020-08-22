package step3.view;

import step3.model.LottoTicket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class OutputView {
    public static final int SCALE = 2;
    private static final String WINNING_COMMENT = "(기준이 1이기 때문에 결과적으로 이득임)";
    private static final String LOSING_COMMENT = "(기준이 1이기 때문에 결과적으로 손해임)";

    public static void checkStatistics(List<LottoTicket> ticketList, String[] answerNumber) {
        int[] result = new int[]{0, 0, 0, 0, 0, 0, 0};
        printStatsIntro();
        for (LottoTicket ticket : ticketList) {
            result[ticket.matchedNumber(answerNumber)] += 1;
        }
        printMatchedResult(result);
        checkTheLastRatioForCalculatingBenefit(ticketList, calculateWinningPrize(result));
    }

    private static void printStatsIntro() {
        System.out.println("당첨통계");
        System.out.println("----------");
    }

    private static void printMatchedResult(int[] result) {
        System.out.println("3개 일치 (5000원)- " + result[3] + " 개");
        System.out.println("4개 일치 (50000원)- " + result[4] + " 개");
        System.out.println("5개 일치 (1500000원)- " + result[5] + " 개");
        System.out.println("6개 일치 (2000000000원)- " + result[6] + " 개");
    }

    private static long calculateWinningPrize(int[] result) {
        return 2000000000 * result[6] + 1500000 * result[5] + 50000 * result[4] + 5000 * result[3];
    }

    private static void checkTheLastRatioForCalculatingBenefit(List<LottoTicket> ticketList, long winnerPrize) {
        int investmentAmount = ticketList.size() * 1000;
        BigDecimal resultRatio = BigDecimal
                .valueOf(winnerPrize)
                .divide(BigDecimal.valueOf(investmentAmount), SCALE, RoundingMode.HALF_UP);
        StringBuilder result = new StringBuilder();
        result.append("총 수익률은 ").append(resultRatio).append("입니다.");
        addCommentBehindResultComment(resultRatio, result);
        System.out.println(result.toString());
    }

    private static void addCommentBehindResultComment(BigDecimal resultRatio, StringBuilder result) {
        if (isBelowOne(resultRatio)) {
            result.append(LOSING_COMMENT);
        }
        if (!isBelowOne(resultRatio)) {
            result.append(WINNING_COMMENT);
        }
    }

    private static boolean isBelowOne(BigDecimal resultRatio) {
        return resultRatio.doubleValue() < 1;
    }
}
