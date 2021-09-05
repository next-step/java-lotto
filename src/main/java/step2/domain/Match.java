package step2.domain;

import step2.vo.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Match {
    private final Map<Rank, Integer> match = new HashMap<>();

    private Profit profit;

    public Match() {
        this.match.put(Rank.FIFTH, 0);
        this.match.put(Rank.FOURTH, 0);
        this.match.put(Rank.THIRD, 0);
        this.match.put(Rank.FIRST, 0);
        this.profit = new Profit(0);
    }

    public Match(Map<Rank, Integer> match, long profit) {
        this.match.putAll(match);
        this.profit = new Profit(profit);
    }

    public void add(int matchCount) {
        if (Rank.isContains(matchCount)) {
            final Rank rank = Rank.createRank(matchCount);
            int numberOfWins = this.match.get(rank);
            this.match.put(rank, numberOfWins + 1);
            this.profit.add(rank);
        }
    }

    public void calculateProfitRate(int inputPrice) {
        this.profit.calculateProfitRate(inputPrice);
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
