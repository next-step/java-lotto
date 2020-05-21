package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoMatch {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 1_500_000),

    NOT_FOUND(-1, -1);

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

    public static LottoMatch valueByCount(final int matchCount) {
        return Stream.of(LottoMatch.values())
            .filter(lottoMatch -> lottoMatch.matchCount == matchCount)
            .findFirst()
            .orElse(NOT_FOUND);
    }

    public static List<LottoMatch> matchesValues() {
        return Arrays.asList(LottoMatch.values()).stream()
            .filter(lottoMatch -> lottoMatch != LottoMatch.NOT_FOUND)
            .collect(Collectors.toList());
    }
}
