package step2.domain;

import java.util.Arrays;

public enum WinningType {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    SECOND_BONUS(5, 300_000_000),
    FIRST(6, 2_000_000_000);

    private static final int SECOND_MATCH_COUNT = 5;

    private int matchCount;
    private int winnings;

    WinningType(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static WinningType findBy(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(type -> type.matchCountEquals(matchCount))
                .findAny()
                .map(type -> {
                    if (type.isSecondMatchCount()) {
                        return type.isBonusType(matchBonus);
                    }
                    return type;
                })
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }

    private boolean matchCountEquals(int expect) {
        return this.matchCount == expect;
    }

    private boolean isSecondMatchCount() {
        return this.matchCount == SECOND_MATCH_COUNT;
    }

    private WinningType isBonusType(boolean matchBonus) {
        return matchBonus ? SECOND_BONUS : SECOND;
    }
}
