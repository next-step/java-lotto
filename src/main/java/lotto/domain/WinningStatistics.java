package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<RANK, Integer> winningStatistics;

    public WinningStatistics() {
        winningStatistics = new HashMap<>();

        winningStatistics.put(RANK.ZERO, 0);
        winningStatistics.put(RANK.ONE, 0);
        winningStatistics.put(RANK.TWO, 0);
        winningStatistics.put(RANK.THREE, 0);
        winningStatistics.put(RANK.FOUR, 0);
        winningStatistics.put(RANK.FIVE, 0);
        winningStatistics.put(RANK.SIX, 0);
    }

    public void setRankCount(List<RANK> rankList) {
        for (RANK rank : rankList) {
            addCount(rank);
        }
    }

    private void addCount(RANK rank) {
        int count = winningStatistics.get(rank);
        winningStatistics.put(rank, count + 1);
    }

    public Map<RANK, Integer> getWinningStatistics() {
        return Collections.unmodifiableMap(winningStatistics);
    }
}
