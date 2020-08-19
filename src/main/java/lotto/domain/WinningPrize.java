package lotto.domain;

import java.util.Arrays;

public enum WinningPrize {

    ZERO(0, 0, "꽝"),
    FORTH(3, 5000, "3개 일치"),
    THIRD(4, 50000, "4개 일치"),
    SECOND(5, 1500000, "5개 일치"),
    FIRST(6, 2000000000, "6개 일치");

    private final int matchCount;
    private final int prize;
    private final String message;

    WinningPrize(int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    static WinningPrize valueOf(int matchCount) {
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
