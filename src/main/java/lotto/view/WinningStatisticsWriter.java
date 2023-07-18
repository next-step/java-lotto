package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.WinningStatistics;

public class WinningStatisticsWriter {

    public void printLottoStatistics(final WinningStatistics winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        final List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        Collections.reverse(lottoRanks);

        for (LottoRank lottoRank : lottoRanks) {
            printEachStatistics(lottoRank, winningStatistics.getWinningCount(lottoRank));
        }

        final double earningRate = Math.floor(winningStatistics.getEarningRate() * 100) / 100;
        System.out.printf("총 수익률은 %.2f 입니다.", earningRate);
        if (earningRate >= 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
            return;
        }
        System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private void printEachStatistics(
            final LottoRank lottoRank,
            final int winningCount
    ) {
        if (lottoRank.equals(LottoRank.NONE)) {
            return;
        }
        System.out.println(formatToStatistics(lottoRank, winningCount));
    }

    private String formatToStatistics(
            final LottoRank lottoRank,
            final int winningCount
    ) {
        StringBuilder result = new StringBuilder();
        result.append(lottoRank.getMatchCount()).append("개 일치");
        if (lottoRank.equals(LottoRank.SECOND)) {
            result.append(", 보너스 볼 일치");
        }
        result.append("(").append(lottoRank.getPrize()).append("원)- ");
        result.append(winningCount).append("개");
        return result.toString();
    }
}
