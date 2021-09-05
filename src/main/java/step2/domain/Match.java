package step2.domain;

import step2.vo.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Match { // todo
    private final Map<Rank, Integer> match = new HashMap<>(); // todo

    private Profit profit;
    private Amount totalPurchaseAmount;

    public Match() {
        this.match.put(Rank.FIFTH, 0);
        this.match.put(Rank.FOURTH, 0);
        this.match.put(Rank.THIRD, 0);
        this.match.put(Rank.FIRST, 0);
        this.profit = new Profit(0);
        this.totalPurchaseAmount = new Amount(0);
    }

    public Match(Map<Rank, Integer> match, long profit, int totalPurchaseAmount) {
        this.match.putAll(match);
        this.profit = new Profit(profit);
        this.totalPurchaseAmount = new Amount(totalPurchaseAmount);
        this.profit.calculateProfitRate(this.totalPurchaseAmount);
    }

    public void add(int matchCount) {
        if (Rank.isContains(matchCount)) {
            final Rank rank = Rank.createRank(matchCount);
            this.match.computeIfPresent(rank, (Rank key, Integer value) -> ++value);
            this.profit.add(rank);
            this.totalPurchaseAmount = this.totalPurchaseAmount.add();
            this.profit.calculateProfitRate(this.totalPurchaseAmount);
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
