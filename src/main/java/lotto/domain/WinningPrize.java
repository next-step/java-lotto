package lotto.domain;

import java.util.Arrays;

public enum WinningPrize {

    ZERO(0, 0, "꽝"),
    FIFTH(3, 5_000, "3개 일치"),
    FORTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final int prize;
    private final String message;

    WinningPrize(int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public static WinningPrize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == SECOND.matchCount && matchBonus) return SECOND;
        return Arrays.stream(WinningPrize.values())
                .filter(winningPrize -> winningPrize.matchCount == matchCount)
                .findFirst()
                .orElse(ZERO);
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
