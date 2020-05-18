package lotto.domain;

import java.util.Optional;
import java.util.stream.Stream;

public enum LottoMatch {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 1_500_000);

    private final int matchCount;
    private final int amount;

    LottoMatch(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

    public static Optional<LottoMatch> valueByCount(final int matchCount) {
        return Stream.of(LottoMatch.values())
            .filter(lottoMatch -> lottoMatch.matchCount == matchCount)
            .findFirst();
    }
}
