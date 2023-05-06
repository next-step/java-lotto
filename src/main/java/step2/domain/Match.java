package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Match {

    private static final List<Match> matchCache;
    private static final Match NOT_MATCH = new Match(0, false);
    private static final Match THREE_MATCH = new Match(3, false);
    private static final Match FOUR_MATCH = new Match(4, false);
    private static final Match FIVE_MATCH = new Match(5, false);
    private static final Match FIVE_MATCH_WITH_BONUS = new Match(5, true);
    private static final Match SIX_MATCH = new Match(6, false);

    private final int count;
    private final boolean isBonus;

    static {
        matchCache = Arrays.asList(
                NOT_MATCH, THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_MATCH_WITH_BONUS, SIX_MATCH
        );
    }

    public Match(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public static Match from(int count, boolean isBonus) {
        return matchCache.stream()
                .filter(match -> match.equals(new Match(count, isBonus)))
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


