package lotto.domain;

import java.util.stream.Stream;

public enum LottoMatch {
    THREE(3,5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 1_500_000);

    private int matchCount;
    private int amount;
    LottoMatch(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static LottoMatch valueByCount(final int matchCount) {
        return Stream.of(LottoMatch.values())
            .filter(lottoMatch -> lottoMatch.matchCount == matchCount)
            .findFirst()
            .orElseThrow(()->new IllegalArgumentException("not exist matchCount"));
    }
}
