package lotto.constant;

import lotto.domain.LottoMarkingNumbers;
import lotto.exception.InvalidMatchCount;

import java.util.stream.Stream;

public enum MatchResult {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    MISS(0, 0);

    private final int matchCount;
    private final int winPrice;

    MatchResult(int matchCount, int winPrice) {
        this.matchCount = matchCount;
        this.winPrice = winPrice;
    }

    public static MatchResult findByMatchCount(int matchCount) {
        if (matchCount > LottoMarkingNumbers.LOTTO_NUMBER_COUNT) {
            throw new InvalidMatchCount();
        }
        return Stream.of(MatchResult.values())
                .filter(matchResult -> matchResult.matchCount == matchCount)
                .findAny()
                .orElse(MISS);
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int winPrice() {
        return this.winPrice;
    }
}
