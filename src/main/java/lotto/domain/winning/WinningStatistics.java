package lotto.domain.winning;

import java.util.*;

/**
 * Created By mand2 on 2020-11-20.
 */
public class WinningStatistics {

    private Map<WinningRank, Integer> stats;

    public WinningStatistics() {
        this.stats = new HashMap<>();

        stats.put(WinningRank.FIRST, 0);
        stats.put(WinningRank.THIRD, 0);
        stats.put(WinningRank.FOURTH, 0);
        stats.put(WinningRank.FIFTH, 0);
        stats.put(WinningRank.NONE, 0);
    }

    public void add(WinningRank winningRank) {
        int prevStats = stats.get(winningRank);
        stats.put(winningRank, prevStats + 1);
    }

    private int sumWinningResult() {
        int result = 0;
        for (WinningRank winningRank : stats.keySet()) {
            result += winningRank.getPrize() * stats.get(winningRank);
        }

        return result;
    }

    public Map<WinningRank, Integer> stats() {
        return Collections.unmodifiableMap(this.stats);
    }

    public double earningRatio(int amount) {
        return sumWinningResult() / (double) amount;
    }


}
