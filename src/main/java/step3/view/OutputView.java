package step3.view;

import step3.model.LottoStat;
import step3.model.Rank;

import java.math.BigDecimal;

public class OutputView {
    private static final String WINNING_COMMENT = "(기준이 1이기 때문에 결과적으로 이득임)";
    private static final String LOSING_COMMENT = "(기준이 1이기 때문에 결과적으로 손해임)";

    public static void checkStatistics(LottoStat stat, int amount) {
        printStatsIntro();
        printMatchedResult(stat);
        checkTheLastRatioForCalculatingBenefit(stat, amount);
    }

    private static void printStatsIntro() {
        System.out.println("당첨통계");
        System.out.println("----------");
    }

    private static void printMatchedResult(LottoStat stat) {
        System.out.println("3개 일치 (5000원)- " + stat.getNumberOfGrade(Rank.FIFTH) + " 개");
        System.out.println("4개 일치 (50000원)- " + stat.getNumberOfGrade(Rank.FOURTH) + " 개");
        System.out.println("5개 일치 (1500000원)- " + stat.getNumberOfGrade(Rank.THIRD) + " 개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + stat.getNumberOfGrade(Rank.SECOND) + " 개");
        System.out.println("6개 일치 (2000000000원)- " + stat.getNumberOfGrade(Rank.FIRST) + " 개");
    }

    private static void checkTheLastRatioForCalculatingBenefit(LottoStat stat, int amount) {
        StringBuilder result = new StringBuilder();
        BigDecimal ratio = stat.getBenefitRatioFromLottoTicket(amount);
        result.append("총 수익률은 ").append(ratio).append("입니다.");
        addCommentBehindResultComment(ratio, result);
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
