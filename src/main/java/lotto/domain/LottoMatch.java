package lotto.domain;

import java.util.Arrays;

public enum LottoMatch {

    LOSE(0, 0),

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    private final int matchCount;
    private final int prize;

    LottoMatch(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int calculatePrize(int count) {
        return this.prize * count;
    }

    public static LottoMatch findEnumByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(LOSE);
    }
}
