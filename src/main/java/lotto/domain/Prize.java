package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Prize {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchCount;
    private final int winningPrize;
    private final boolean matchBonus;

    Prize(int matchCount, int winningPrize, Boolean matchBonus) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public boolean checkPrize(int matchCount, boolean matchBonus) {
        if (matchCount == Prize.SECOND.getMatchCount()) {
            return this.getMatchBonus() == matchBonus;
        }
        return this.getMatchCount() <= matchCount;
    }

    public static Prize valueOf(int matchCount, boolean matchBonus) {
        Prize properPrize = Arrays.stream(Prize.values())
                .filter(prize -> prize.checkPrize(matchCount, matchBonus))
                .findFirst()
                .orElseThrow();

        return properPrize;
    }

    public static boolean isSecondPrize(Prize prize) {
        return prize.equals(Prize.SECOND);
    }


}
