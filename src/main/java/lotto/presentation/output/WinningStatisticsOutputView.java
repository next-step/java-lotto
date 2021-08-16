package lotto.presentation.output;

import lotto.domain.LottoResults;
import lotto.domain.Ranking;

public class WinningStatisticsOutputView {
    private static final String WINNING_STATISTICS_OUTPUT_COMMENT = "당첨 통계\n---------";

    private static final String WINNING_STATISTICS_COMMENT = "%d개 일치 (%d원) - %d개%n";
    private static final String WINNING_STATISTICS_RANKING_2ND_COMMENT = "%d개 일치, 보너스 볼 일치(%d원) - %d개%n";

    public void output(LottoResults lottoResults) {
        System.out.println(WINNING_STATISTICS_OUTPUT_COMMENT);
        outputLottoExpectAndHits(lottoResults);
    }

    private void outputLottoExpectAndHits(LottoResults lottoResults) {
        for (Ranking ranking : Ranking.values()) {
            int expect = ranking.getExpect();
            int compensation = ranking.getCompensation();
            int hits = lottoResults.getRankingHits(ranking);
            System.out.printf(getWinningStaticsComment(ranking), expect, compensation, hits);
        }
    }

    private String getWinningStaticsComment(Ranking ranking) {
        if (ranking == Ranking.SECOND) {
            return WINNING_STATISTICS_RANKING_2ND_COMMENT;
        }
        return WINNING_STATISTICS_COMMENT;
    }
}
