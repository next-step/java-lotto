package lotto.constants;

import java.util.Arrays;

public enum Winning {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 50000),
    FIFTH(2, 0),
    SIXTH( 1, 0),
    BLANK(0, 0);

    private static final String MESSAGE = "%s개 일치 (%s원)";

    private final String message;
    private final int matchCount;
    private int prize;

    Winning(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = String.format(MESSAGE, matchCount, prize);
    }

    public static Winning of(long matchCount) {
        return Arrays.stream(values())
                .filter(winning -> winning.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid match count: " + matchCount));
    }

    public String message() {
        return message;
    }

    public int matchCount() {
        return matchCount;
    }

    public int prize() {
        return prize;
    }
}
