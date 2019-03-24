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
        long totalPrizeMoney = 0;

        Set<Rank> winningResultsKeys = winningResults.keySet();

        for (Rank rank : winningResultsKeys) {
            totalPrizeMoney += rank.getMoney() * winningResults.get(rank).getMatchCount();
        }

        return totalPrizeMoney / (double) money;
    }
}
