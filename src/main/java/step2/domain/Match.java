package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Match {

    private static final List<Match> matchCache = new ArrayList<>();
    private static final Match NOT_MATCH = new Match(0, false);

    private final int count;
    private final boolean isBonus;

    static {
        matchCache.add(new Match(0, false));
        matchCache.add(new Match(3, false));
        matchCache.add(new Match(4, false));
        matchCache.add(new Match(5, false));
        matchCache.add(new Match(5, true));
        matchCache.add(new Match(6, false));
    }

    public Match(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public static Match from(int count, boolean isBonus) {
        return matchCache.stream()
                .filter(match -> match.equals(from(count, isBonus)))
                .findAny()
                .orElse(NOT_MATCH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return count == match.count && isBonus == match.isBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, isBonus);
    }
}


