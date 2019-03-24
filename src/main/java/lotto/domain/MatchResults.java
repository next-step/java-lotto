package lotto.domain;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MatchResults {

    private Map<Rank, RankCount> matchResults;

    public MatchResults() {
        matchResults = new TreeMap<>();
    }

    public RankCount get(Rank rank) {
        return matchResults.get(rank);
    }

    protected RankCount put(Rank rank, RankCount rankCount) {
        return matchResults.put(rank, rankCount);
    }

    public Set<Rank> keySet() {
        return matchResults.keySet();
    }

    public double calculateEarningsRate(final long money) {
        long reward = 0;

        Set<Rank> ranks = matchResults.keySet();

        for (Rank rank : ranks) {
            reward += rank.calculateReward(matchResults.get(rank));
        }

        return reward / (double) money;
    }
}
