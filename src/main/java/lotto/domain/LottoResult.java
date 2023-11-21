package lotto.domain;

import java.util.Arrays;

public enum LottoResult {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
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
