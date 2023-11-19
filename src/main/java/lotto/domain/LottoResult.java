package lotto.domain;

import java.util.Arrays;

public enum LottoResult {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

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
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 당첨정보입니다."));
    }

}
