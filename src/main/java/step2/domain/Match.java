package step2.domain;

import step2.vo.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Match {
    private static final int PRICE = 1000;

    private final Map<Rank, Integer> match = new HashMap<>();

    private Profit profit;
    private int cumulativeNumberOfPurchases; // todo

    public Match() {
        this.match.put(Rank.FIFTH, 0);
        this.match.put(Rank.FOURTH, 0);
        this.match.put(Rank.THIRD, 0);
        this.match.put(Rank.FIRST, 0);
        this.profit = new Profit(0);
        this.cumulativeNumberOfPurchases = 0;
    }

    public Match(Map<Rank, Integer> match, long profit, int cumulativeNumberOfPurchases) {
        this.match.putAll(match);
        this.profit = new Profit(profit);
        this.cumulativeNumberOfPurchases = cumulativeNumberOfPurchases;
        this.profit.calculateProfitRate(this.cumulativeNumberOfPurchases * PRICE);
    }

    public void add(int matchCount) { // winning lotto에서 쓴다
        if (Rank.isContains(matchCount)) {
            final Rank rank = Rank.createRank(matchCount);
            int numberOfWins = this.match.get(rank);
            this.match.put(rank, numberOfWins + 1);
            this.profit.add(rank);
            this.cumulativeNumberOfPurchases = this.cumulativeNumberOfPurchases + 1;
            this.profit.calculateProfitRate(this.cumulativeNumberOfPurchases * PRICE);
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("당첨 통계\n")
                .append("---------\n")
                .append(Rank.FIFTH).append("- ")
                .append(this.match.get(Rank.FIFTH)).append("개\n")
                .append(Rank.FOURTH).append("- ")
                .append(this.match.get(Rank.FOURTH)).append("개\n")
                .append(Rank.THIRD).append("- ")
                .append(this.match.get(Rank.THIRD)).append("개\n")
                .append(Rank.FIRST).append("- ")
                .append(this.match.get(Rank.FIRST)).append("개\n")
                .append(profit)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        Match match1 = (Match) o;
        return Objects.equals(match, match1.match) && Objects.equals(profit, match1.profit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, profit);
    }
}
