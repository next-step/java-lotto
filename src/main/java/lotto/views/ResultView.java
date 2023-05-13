package lotto.views;

import lotto.LottoStatistics;

import java.math.BigDecimal;

public class ResultView {

    public static void statisticsResult(LottoStatistics lottoStatistics, BigDecimal payment) {
        System.out.println("당첨 통계");
        System.out.println("-------------");
        printStatistics(lottoStatistics);
        System.out.println("총 수익률은 " + lottoStatistics.rateOfReturn(payment) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        for (LottoStatistics.Winnings value : LottoStatistics.Winnings.values()) {
            System.out.println(value.getMatchCount() + "개 일치 (" + value.getPrize() + "원) - " + lottoStatistics.getWinningsCount(value));
        }
    }

}
