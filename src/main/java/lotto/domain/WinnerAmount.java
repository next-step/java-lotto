package lotto.domain;

import java.util.Arrays;

public enum WinnerAmount {
    ZERO(0, 0, "꽝"),
    FIFTH(3, 5000, "3개 일치"),
    FORTH(4, 50000, "4개 일치"),
    THIRD(5, 1500000, "5개 일치"),
    SECOND(5, 30000000, "5개 일치 보너스 볼 일치"),
    FIRST(6, 2000000000, "6개 일치");

    private final int match;
    private final int prize;
    private final String message;

    WinnerAmount(int match, int prize, String message) {
        this.match = match;
        this.prize = prize;
        this.message = message;
    }

    public static WinnerAmount matchCheck(int matchNumber, boolean checkResult) {
        if(checkResult && matchNumber == WinnerAmount.SECOND.match) {
            return SECOND;
        }

        return Arrays.stream(WinnerAmount.values())
                .filter(s -> s.match == matchNumber)
                .findAny()
                .orElse(ZERO);
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
