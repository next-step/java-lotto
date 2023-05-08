package study.lotto.step2.domain;


import java.util.Arrays;

public enum LottoResult {
    NOT_WIN(0, 0L),
    MATCH_THREE_NUMBERS(3, 5_000L),
    MATCH_FOUR_NUMBERS(4, 50_000L),
    MATCH_FIVE_NUMBERS(5, 1_500_000L),
    MATCH_FIVE_NUMBERS_WITH_BONUS(5, 3_000_000L),
    MATCH_SIX_NUMBERS(6, 2_000_000_000L);

    private final int numberOfMatches;
    private final long payout;

    LottoResult(int numberOfMatches, long payout) {
        this.numberOfMatches = numberOfMatches;
        this.payout = payout;
    }

    public long payout() {
        return payout;
    }

    public int numberOfMatches() {
        return numberOfMatches;
    }

    public static LottoResult of(int numberOfMatches, boolean isBonusMatch) {
        if(isMatchFiveNumbers(numberOfMatches)) {
            return ofMatchFiveNumbers(isBonusMatch);
        }

        return ofExceptMatchFiveNumbers(numberOfMatches);
    }

    private static boolean isMatchFiveNumbers(int numberOfMatches) {
        return numberOfMatches == MATCH_FIVE_NUMBERS.numberOfMatches();
    }

    private static LottoResult ofExceptMatchFiveNumbers(int numberOfMatches) {
        return Arrays.stream(values())
                .filter(lottoResult -> numberOfMatches == lottoResult.numberOfMatches && !isMatchFiveNumbers(numberOfMatches))
                .findAny()
                .orElse(NOT_WIN);
    }

    private static LottoResult ofMatchFiveNumbers(boolean isBonusMatch) {
        if(isBonusMatch) {
            return MATCH_FIVE_NUMBERS_WITH_BONUS;
        }

        return MATCH_FIVE_NUMBERS;
    }
}
