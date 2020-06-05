package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int winningPrize;

    Prize(int matchCount, int winningPrize) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public static Prize getMatchPrize(int matchCount) {
        Prize properPrize = Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElseThrow();

        return properPrize;
    }

    public static Prize valueOf(int rightCount, boolean matchBonus) {
        Prize properPrize = Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount() == rightCount)
                .findFirst()
                .orElseThrow();

        return isSecondPrize(properPrize, matchBonus);
    }

    private static Prize isSecondPrize(Prize properPrize, boolean matchBonus) {
        if(properPrize.getMatchCount() == SECOND.getMatchCount() && matchBonus) {
            return Prize.SECOND;
        }
        return properPrize;
    }
}
