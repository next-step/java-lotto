package step2.domain.statistics;

import step2.vo.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Match {
    private Map<Rank, Integer> match = new HashMap(){
        {
            put(Rank.FIFTH, 0);
            put(Rank.FOURTH, 0);
            put(Rank.THIRD, 0);
            put(Rank.SECOND, 0);
            put(Rank.FIRST, 0);
        }
    };

    public Match() {

    }

    public Match(Rank rank, int matchCount) {
        if (this.match.containsKey(rank)) {
            this.match.put(rank, matchCount);
        }
    }

    public Match(Rank rank) {
        this(rank, 1);
    }

    public Match(Map<Rank, Integer> match) {
        this.match.putAll(match);
    }

    public void add(Rank rank) {
        if (this.match.containsKey(rank)) {
            Integer numberOfMatches = this.match.get(rank);
            this.match.put(rank, ++numberOfMatches);
        }
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(Rank.FIFTH).append("- ")
                .append(this.match.get(Rank.FIFTH)).append("개\n")
                .append(Rank.FOURTH).append("- ")
                .append(this.match.get(Rank.FOURTH)).append("개\n")
                .append(Rank.THIRD).append("- ")
                .append(this.match.get(Rank.THIRD)).append("개\n")
                .append(Rank.SECOND).append("- ")
                .append(this.match.get(Rank.SECOND)).append("개\n")
                .append(Rank.FIRST).append("- ")
                .append(this.match.get(Rank.FIRST)).append("개")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        Match match1 = (Match) o;
        return Objects.equals(match, match1.match);
    }

    @Override
    public int hashCode() {
        return Objects.hash(match);
    }
}
