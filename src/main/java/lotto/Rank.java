package lotto;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    SIXTH(2, 0, false),
    SEVENTH(1, 0, false),
    EIGHTH(0, 0, false);

    private final int matchCount;
    private final int winnings;
    private final boolean matchedBonus;

    Rank(int matchCount, int winnings, boolean matchedBonus) {
        this.matchCount = matchCount;
        this.winnings = winnings;
        this.matchedBonus = matchedBonus;
    }

    public static Rank findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.matchedBonus == matchBonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("0 ~ 6이외의 matchCount 는 발생할 수 없습니다."));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }
}
