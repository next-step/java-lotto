package step3.iksoo.lotto2rd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class MatchResult {
    private Map<Rank, Integer> matchResult;

    MatchResult(Map<Rank, Integer> matchResult) {
        this.matchResult = matchResult;
    }

    public double calculateRateProfit(int orderPrice) {
        return (double) calculatePrize() / orderPrice;
    }

    public int calculatePrize() {
        return Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank.getCountOfMatch() >= Rank.FIFTH.getCountOfMatch())
                .mapToInt(rank -> rank.getWinningMoney() * matchResult.get(rank))
                .sum();
    }

    public Map<Rank, Integer> getMatchResult() {
        return this.matchResult;
    }
}
