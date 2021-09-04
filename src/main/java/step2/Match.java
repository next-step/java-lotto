package step2;

import java.util.HashMap;
import java.util.Map;

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

    public void add(int matchCount) {
        if (MatchNumber.isContains(matchCount)) {
            final MatchNumber matchNumber = MatchNumber.createMatchNumber(matchCount);
            int numberOfWins = this.match.get(matchNumber);
            this.match.put(matchNumber, numberOfWins + 1);
            this.profit.add(matchNumber);
        }
    }

    public int getMatchCount(MatchNumber matchNumber) { // todo test, 출력문에서만 쓰임
        return this.match.get(matchNumber);
    }

    public void calculateProfitRate(int inputPrice) {
        this.profit.calculateProfitRate(inputPrice);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("당첨 통계\n")
                .append("---------\n")
                .append(MatchNumber.THREE).append("- ")
                .append(this.getMatchCount(MatchNumber.THREE)).append("개\n")
                .append(MatchNumber.FOUR).append("- ")
                .append(this.getMatchCount(MatchNumber.FOUR)).append("개\n")
                .append(MatchNumber.FIVE).append("- ")
                .append(this.getMatchCount(MatchNumber.FIVE)).append("개\n")
                .append(MatchNumber.SIX).append("- ")
                .append(this.getMatchCount(MatchNumber.SIX)).append("개\n")
                .append(profit)
                .toString();
    }
}
