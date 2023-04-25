package step2.domain;

import java.util.Objects;

public class Match {

    private final int match;
    private final boolean isBonus;

    public Match(int match, boolean isBonus) {
        this.match = match;
        this.isBonus = isBonus;
    }

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return isBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match1 = (Match) o;
        return match == match1.match && isBonus == match1.isBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, isBonus);
    }
}


