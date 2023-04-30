package step2.domain;

import java.util.Arrays;
import java.util.List;

public class MatchFactory {

    private static final Match NOT_MATCH = new Match(0, false);
    private static final Match THREE_MATCH = new Match(3, false);
    private static final Match FOUR_MATCH = new Match(4, false);
    private static final Match FIVE_MATCH = new Match(5, false);
    private static final Match FIVE_MATCH_WITH_BONUS = new Match(5, true);
    private static final Match SIX_MATCH = new Match(6, false);

    private static final List<Match> factory = Arrays.asList(
            THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_MATCH_WITH_BONUS, SIX_MATCH
    );


    public static Match match(int count, boolean isBonus) {
        return factory.stream()
                .filter(match -> match.isEqual(count, isBonus))
                .findAny()
                .orElse(NOT_MATCH);
    }
}
