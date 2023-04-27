package step2.domain;

public class MatchFactory {

    private static final Match NOT_MATCH = new Match(0, false);
    private static final Match THREE_MATCH = new Match(3, false);
    private static final Match FOUR_MATCH = new Match(4, false);
    private static final Match FIVE_MATCH = new Match(5, false);
    private static final Match FIVE_MATCH_WITH_BONUS = new Match(5, true);
    private static final Match SIX_MATCH = new Match(6, false);


    public static Match match(int count, boolean isBonus) {

        if (count == 3 && !isBonus) {
            return THREE_MATCH;
        }

        if (count == 4 && !isBonus) {
            return FOUR_MATCH;
        }

        if (count == 5 && !isBonus) {
            return FIVE_MATCH;
        }

        if (count == 5 && isBonus) {
            return FIVE_MATCH_WITH_BONUS;
        }

        if (count == 6 && !isBonus) {
            return SIX_MATCH;
        }

        return NOT_MATCH;
    }
}
