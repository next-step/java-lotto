package lotto.domain;

import java.util.Objects;

public class Match implements Comparable<Match> {
    private final int match;

    public Match(int match) {
        this.match = match;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match1 = (Match) o;
        return match == match1.match;
    }

    @Override
    public int hashCode() {
        return Objects.hash(match);
    }

    @Override
    public int compareTo(Match match) {
        if (match.match < this.match) {
            return 1;
        } else if (match.match > this.match) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return Integer.toString(match);
    }
}
