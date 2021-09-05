package step2.domain.statistics;

import step2.vo.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Match {
    private Map<Rank, Integer> match = new HashMap<>();

    public Match() {
        this.match.put(Rank.FIFTH, 0);
        this.match.put(Rank.FOURTH, 0);
        this.match.put(Rank.THIRD, 0);
        this.match.put(Rank.FIRST, 0);
    }

    public Match(Map<Rank, Integer> match) {
        this.match.putAll(match);
    }

    public int computeIfPresent(Rank rank) {
        return this.match.computeIfPresent(rank,
                (Rank key, Integer numberOfMatches) -> ++numberOfMatches);
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
                .append(Rank.FIRST).append("- ")
                .append(this.match.get(Rank.FIRST)).append("개\n")
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
