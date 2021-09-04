package step2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Match {
    private final Map<MatchNumber, Integer> match = new HashMap<>();

    private Profit profit;

    public Match() {
        this.match.put(MatchNumber.THREE, 0);
        this.match.put(MatchNumber.FOUR, 0);
        this.match.put(MatchNumber.FIVE, 0);
        this.match.put(MatchNumber.SIX, 0);
        this.profit = new Profit(0);
    }

    public Match(Map<MatchNumber, Integer> match, long profit) {
        this.match.putAll(match);
        this.profit = new Profit(profit);
    }

    public void add(int matchCount) {
        if (MatchNumber.isContains(matchCount)) {
            final MatchNumber matchNumber = MatchNumber.createMatchNumber(matchCount);
            int numberOfWins = this.match.get(matchNumber);
            this.match.put(matchNumber, numberOfWins + 1);
            this.profit.add(matchNumber);
        }
    }

    public void calculateProfitRate(int inputPrice) {
        this.profit.calculateProfitRate(inputPrice);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("당첨 통계\n")
                .append("---------\n")
                .append(MatchNumber.THREE).append("- ")
                .append(this.match.get(MatchNumber.THREE)).append("개\n")
                .append(MatchNumber.FOUR).append("- ")
                .append(this.match.get(MatchNumber.FOUR)).append("개\n")
                .append(MatchNumber.FIVE).append("- ")
                .append(this.match.get(MatchNumber.FIVE)).append("개\n")
                .append(MatchNumber.SIX).append("- ")
                .append(this.match.get(MatchNumber.SIX)).append("개\n")
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
