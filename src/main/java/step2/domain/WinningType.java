package step2.domain;

import java.util.Arrays;

public enum WinningType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private int matchCount;
    private int winnings;

    WinningType(int matchCount, int winnings) {
        this.matchCount = matchCount;
        this.winnings = winnings;
    }

    public static WinningType findBy(int matchCount) {
        return Arrays.stream(values())
                .filter(type -> type.eq(matchCount))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getWinnings() {
        return winnings;
    }

    private boolean eq(int expect) {
        return this.matchCount == expect;
    }
}
