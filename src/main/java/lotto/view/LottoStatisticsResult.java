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

    public String rank(Rank rank) {
        if (rank == Rank.BONUS) {
            return String.format("%d개 일치, 보너스 볼 일치(%d)- %d개", rank.count(), rank.winningMoney(), getMatchCount(rank));
        }

        return String.format("%d개 일치 (%d)- %d개", rank.count(), rank.winningMoney(), getMatchCount(rank));
    }

    private int getMatchCount(Rank rank) {
        return statistics.getMatchCount(rank);
    }
}
