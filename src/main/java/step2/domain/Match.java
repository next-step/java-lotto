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

    private Match(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public static Match from(int count, boolean isBonus) {
        return matchCache.stream()
                .filter(match -> match.count == count && match.isBonus == isBonus)
                .findAny()
                .orElse(NOT_MATCH);
    }
}


