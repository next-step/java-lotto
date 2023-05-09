package lotto.model.enums;

import java.util.Arrays;

public enum MatchingStrategy {
    SIX(6, false,2000000000),
    FIVE_WITH_BONUS(5, true,30000000),
    FIVE(5, false,1500000),
    FOUR(4, false,50000),
    THREE(3, false,5000);

    private int count;

    private boolean matchBonus;
    private int reword;

    MatchingStrategy(int count, boolean matchBonus, int reword) {

        this.count = count;
        this.matchBonus = matchBonus;
        this.reword = reword;
    }

    public static MatchingStrategy find(int count, boolean matchBonus) {
        try {
            return Arrays.stream(MatchingStrategy.values())
                    .filter(ranking -> ranking.getCount() == count && ranking.getMatchBonus() == matchBonus)
                    .findFirst().orElse(null);
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }

    public int getCount() {
        return count;
    }

    public int getReword() {
        return reword;
    }
    public boolean getMatchBonus() {
        return matchBonus;
    }
}
