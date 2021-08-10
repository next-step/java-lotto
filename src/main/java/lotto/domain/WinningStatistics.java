package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics() {
        winningStatistics = new HashMap<>();

        winningStatistics.put(Rank.ZERO, 0);
        winningStatistics.put(Rank.ONE, 0);
        winningStatistics.put(Rank.TWO, 0);
        winningStatistics.put(Rank.THREE, 0);
        winningStatistics.put(Rank.FOUR, 0);
        winningStatistics.put(Rank.FIVE, 0);
        winningStatistics.put(Rank.SIX, 0);
    }

    public void setRankCount(List<Rank> rankList) {
        for (Rank rank : rankList) {
            addCount(rank);
        }
    }

    private void addCount(Rank rank) {
        int count = winningStatistics.get(rank);
        winningStatistics.put(rank, count + 1);
    }

    public Map<Rank, Integer> getWinningStatistics() {
        return Collections.unmodifiableMap(winningStatistics);
    }
}
