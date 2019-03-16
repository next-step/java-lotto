package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    SEVENTH(0, 0);

    private int matchCount;

    private int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoPrize getEnumNameByIntValue(int matchCount) throws IllegalArgumentException {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("해당 카운트는 없음 : %d", matchCount)));
    }

    public int getPrize() {
        return prize;
    }
}
