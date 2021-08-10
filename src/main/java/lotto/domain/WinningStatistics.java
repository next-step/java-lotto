package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> winningStatistics = new HashMap<>();

    public void setRankCount(List<Rank> rankList) {
        for (Rank rank : rankList) {
            addCount(rank);
        }
    }

    private void addCount(Rank rank) {
        winningStatistics.put(rank, winningStatistics.getOrDefault(rank, 0) + 1);
    }

    public Map<Rank, Integer> getWinningStatistics() {
        return Collections.unmodifiableMap(winningStatistics);
    }
}
