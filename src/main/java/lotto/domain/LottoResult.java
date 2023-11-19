package lotto.domain;

import java.util.Arrays;

public enum LottoResult {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    FAIL(0, 0);

    private final int matchCount;
    private final int prize;

    LottoResult(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoResult findResult(int matchCount) {
        return Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findAny()
                .orElse(LottoResult.FAIL);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int prize() {
        return this.prize;
    }
}
