package step2.domain;

import java.util.Arrays;

public enum WinningType {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private int matchCount;
    private int winnings;

    WinningType(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static WinningType findBy(int matchCount) {
        return Arrays.stream(values())
                .filter(type -> type.matchCountEquals(matchCount))
                .findAny()
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
}
