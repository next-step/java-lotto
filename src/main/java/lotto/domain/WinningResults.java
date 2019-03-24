package lotto.domain;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WinningResults {

    private Map<Rank, RankCount> winningResults;

    public WinningResults() {
        winningResults = new TreeMap<>();
    }

    public RankCount get(Rank rank) {
        return winningResults.get(rank);
    }

    protected RankCount put(Rank rank, RankCount rankCount) {
        return winningResults.put(rank, rankCount);
    }

    public Set<Rank> keySet() {
        return winningResults.keySet();
    }

    public double calculateEarningsRate(final long money) {
        long totalWinningMoney = 0;

        Set<Rank> ranks = winningResults.keySet();

        for (Rank rank : ranks) {
            totalWinningMoney += rank.calculateWinningMoney(winningResults.get(rank));
        }

        return totalWinningMoney / (double) money;
    }
}
