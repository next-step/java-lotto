package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.type.Rank;

public class LottoStatisticsResult {

    private final LottoStatistics statistics;

    public LottoStatisticsResult(LottoStatistics statistics) {
        this.statistics = statistics;
    }

    public String profit() {
        return String.format("%.2f", statistics.profit());
    }

    public int getMatchCount(Rank rank) {
        return statistics.getMatchCount(rank);
    }
}
