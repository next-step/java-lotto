package lotto.utils;

import lotto.domain.Rank;
import lotto.domain.WinnerStatistics;

import java.util.*;

public class StatisticsExporter {
    private static final String MATCHED_RANK_STATUS_MESSAGE = "%s %d개";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.02f입니다.";
    private static final int ASCENDING_SORT = -1;
    private final WinnerStatistics winnerStatistics;

    public StatisticsExporter(final WinnerStatistics winnerStatistics) {
        this.winnerStatistics = winnerStatistics;
    }

    public String exportStatistics() {
        final StringBuilder exportResult = new StringBuilder();
        Arrays
                .stream(Rank.values())
                .sorted((rank1, rank2) -> ASCENDING_SORT)
                .filter(this::isValuable)
                .map(rank -> {
                    int matchCount = getMatchCount(rank);
                    return decorateRankResult(rank, matchCount);
                })
                .forEach(rankResult -> exportResult.append(rankResult).append("\n"));

        return exportResult.toString();
    }

    public String exportEarningRate() {
        return String.format(EARNING_RATE_MESSAGE, winnerStatistics.getEarningRate());
    }

    private boolean isValuable(final Rank rank) {
        return rank != Rank.NONE;
    }

    private int getMatchCount(final Rank rank) {
        EnumMap<Rank, Integer> results = winnerStatistics.getResults();
        return results.getOrDefault(rank, 0);
    }

    private String decorateRankResult(final Rank rank, final int matchCount) {
        return String
                .format(MATCHED_RANK_STATUS_MESSAGE
                        , rank.toString()
                        , matchCount
                );
    }
}
