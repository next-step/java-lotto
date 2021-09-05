package step2.domain;

import step2.vo.MatchNumberVO;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Match {
    private final Map<MatchNumberVO, Integer> match = new HashMap<>();

    private Profit profit;

    public Match() {
        this.match.put(MatchNumberVO.THREE, 0);
        this.match.put(MatchNumberVO.FOUR, 0);
        this.match.put(MatchNumberVO.FIVE, 0);
        this.match.put(MatchNumberVO.SIX, 0);
        this.profit = new Profit(0);
    }

    public Match(Map<MatchNumberVO, Integer> match, long profit) {
        this.match.putAll(match);
        this.profit = new Profit(profit);
    }

    public void add(int matchCount) {
        if (MatchNumberVO.isContains(matchCount)) {
            final MatchNumberVO matchNumberVO = MatchNumberVO.createMatchNumber(matchCount);
            int numberOfWins = this.match.get(matchNumberVO);
            this.match.put(matchNumberVO, numberOfWins + 1);
            this.profit.add(matchNumberVO);
        }
    }

    public void calculateProfitRate(int inputPrice) {
        this.profit.calculateProfitRate(inputPrice);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("당첨 통계\n")
                .append("---------\n")
                .append(MatchNumberVO.THREE).append("- ")
                .append(this.match.get(MatchNumberVO.THREE)).append("개\n")
                .append(MatchNumberVO.FOUR).append("- ")
                .append(this.match.get(MatchNumberVO.FOUR)).append("개\n")
                .append(MatchNumberVO.FIVE).append("- ")
                .append(this.match.get(MatchNumberVO.FIVE)).append("개\n")
                .append(MatchNumberVO.SIX).append("- ")
                .append(this.match.get(MatchNumberVO.SIX)).append("개\n")
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
