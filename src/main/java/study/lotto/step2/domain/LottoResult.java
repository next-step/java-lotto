package study.lotto.step2.domain;

import java.util.Arrays;

public enum LottoResult {
    NOT_WIN(0, false, 0L),
    MATCH_THREE_NUMBERS(3, false, 5_000L),
    MATCH_FOUR_NUMBERS(4, false, 50_000L),
    MATCH_FIVE_NUMBERS(5, false, 1_500_000L),
    MATCH_FIVE_NUMBERS_WITH_BONUS(5, true, 1_500_000L),
    MATCH_SIX_NUMBERS(6, false, 2_000_000_000L);

    private final int numberOfMatches;
    private final boolean isBonusMatch;
    private final long payout;

    LottoResult(int numberOfMatches, boolean isBonusMatch, long payout) {
        this.numberOfMatches = numberOfMatches;
        this.isBonusMatch = isBonusMatch;
        this.payout = payout;
    }

    public long payout() {
        return payout;
    }

    public int numberOfMatches() {
        return numberOfMatches;
    }

    public static LottoResult of(int numberOfMatches, boolean isBonusMatch) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.numberOfMatches == numberOfMatches && lottoResult.isBonusMatch == isBonusMatch)
                .findAny()
                .orElse(NOT_WIN);
    }
}
