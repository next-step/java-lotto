package step4.iksoo.lottoManual;

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
        return Rank.winValues().stream()
                .mapToInt(rank -> rank.prizeAmount(matchResult.get(rank)))
                .sum();
    }

    public Map<Rank, Integer> getMatchResult() {
        return this.matchResult;
    }
}
