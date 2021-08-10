package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics(Map<Rank, Integer> rankMap) {
        this.winningStatistics = new HashMap<>(rankMap);
    }

    public int getRankCount(Rank rank) {
        if (validRankIsNull(rank)) {
            return winningStatistics.get(rank);
        }
        return 0;
    }

    private boolean validRankIsNull(Rank rank) {
        return rank != null;
    }

}
