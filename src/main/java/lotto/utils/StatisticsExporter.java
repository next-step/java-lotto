package lotto.utils;

import lotto.domain.Rank;
import lotto.domain.WinnerStatistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class StatisticsExporter {
    private final String MATCHED_RANK_STATUS_MESSAGE = "%s %d개";
    private final String EARNING_RATE_MESSAGE = "총 수익률은 %.02f입니다.";
    private final WinnerStatistics winnerStatistics;

    public StatisticsExporter(final WinnerStatistics winnerStatistics) {
        this.winnerStatistics = winnerStatistics;
    }

    public String exportStatistics() {
        final StringBuilder exportResult = new StringBuilder();
        final List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);

        for (final Rank rank : ranks) {
            if (isNone(rank)) continue;
            EnumMap<Rank, Integer> results = winnerStatistics.getResults();
            int matchCount = results.getOrDefault(rank, 0);
            String matchedRankStatus = String.format(MATCHED_RANK_STATUS_MESSAGE, rank.toString(), matchCount);
            exportResult.append(matchedRankStatus).append("\n");
        }

        return exportResult.toString();
    }

    public String exportEarningRate() {
        return String.format(EARNING_RATE_MESSAGE, winnerStatistics.getEarningRate());
    }

    private boolean isNone(final Rank rank) {
        return rank == Rank.NONE;
    }
}
