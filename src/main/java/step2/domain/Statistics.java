package step2.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final List<MatchResult> matchResults;

    public Statistics(List<MatchResult> matchResults) {
        this.matchResults = matchResults;
    }

    public Map<Rank, Integer> winningCounts() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        matchResults.stream()
                .map(MatchResult::getRank)
                .filter(Rank::isWinning)
                .forEach(rank -> result.merge(rank, 1, Integer::sum));

        return result;
    }

    public double profitRate(int totalMoneySpent) {
        int totalPrize = matchResults.stream()
                .map(MatchResult::getRank)
                .filter(Rank::isWinning)
                .mapToInt(Rank::reward)
                .sum();
        return (double) totalPrize / totalMoneySpent;
    }

}
