package lotto.model.enums;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, false,2000000000),
    BONUS(5, true,30000000),
    SECOND(5, false,1500000),
    THIRD(4, false,50000),
    FOURTH(3, false,5000);

    private int count;

    private boolean matchBonus;
    private int reword;

    Ranking(int count, boolean matchBonus,  int reword) {

        this.count = count;
        this.matchBonus = matchBonus;
        this.reword = reword;
    }

    public static Ranking findRanking (int count, boolean matchBonus) {
        try {
            return Arrays.stream(Ranking.values())
                    .filter(r -> r.getCount() == count && r.getMatchBonus() == matchBonus)
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
