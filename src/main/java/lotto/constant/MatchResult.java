package lotto.constant;

import java.util.stream.Stream;

public enum MatchResult {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int winPrice;

    MatchResult(int matchCount, int winPrice) {
        this.matchCount = matchCount;
        this.winPrice = winPrice;
    }

    public static MatchResult findByMatchCount(int matchCount) {
        return Stream.of(MatchResult.values())
                .filter(mc -> mc.matchCount == matchCount)
                .findAny()
                .orElse(null);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int winPrice() {
        return this.winPrice;
    }
}
