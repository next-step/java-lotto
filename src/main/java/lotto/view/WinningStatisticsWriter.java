package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoRule;
import lotto.domain.WinningStatistics;

public class WinningStatisticsWriter {

    public void printLottoStatistics(final WinningStatistics winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        final List<LottoRule> lottoRules = Arrays.asList(LottoRule.values());정
        Collections.reverse(lottoRules);

        for (LottoRule lottoRule : lottoRules) {
            printEachStatistics(winningStatistics, lottoRule);
        }

        final double earningRate = Math.floor(winningStatistics.getEarningRate() / 100) * 100;
        System.out.printf("총 수익률은 %.2f 입니다.", earningRate);
        if (earningRate >= 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
            return;
        }
        System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private void printEachStatistics(
            final WinningStatistics winningStatistics,
            final LottoRule lottoRule
    ) {
        if (lottoRule.equals(LottoRule.NONE)) {
            return;
        } else if (lottoRule.equals(LottoRule.SECOND)) {
            System.out.println(formatToStatisticsForSecondRank(
                    lottoRule.getMatchCount(),
                    lottoRule.getPrize(),
                    winningStatistics.getWinningCount(lottoRule)));
            return;
        }
        System.out.println(formatToStatistics(
                lottoRule.getMatchCount(),
                lottoRule.getPrize(),
                winningStatistics.getWinningCount(lottoRule)));
    }

    private String formatToStatisticsForSecondRank(
            final int matchCount,
            final int prize,
            final int boughtCount
    ) {
        return matchCount + "개 일치 , 보너스 볼 일치(" + prize + "원)- " + boughtCount + "개";
    }

    private String formatToStatistics(
            final int matchCount,
            final int prize,
            final int boughtCount
    ) {
        return matchCount + "개 일치 (" + prize + "원)- " + boughtCount + "개";
    }
}
