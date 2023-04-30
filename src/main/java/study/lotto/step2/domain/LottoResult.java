package study.lotto.step2.domain;

import java.util.Arrays;

public enum LottoResult {

    NOT_MATCH(0, false, 0L),
    MATCH_ONE_NUMBER(1, false, 0L),
    MATCH_TWO_NUMBERS(2, false, 0L),
    MATCH_THREE_NUMBERS(3, true, 5_000L),
    MATCH_FOUR_NUMBERS(4, true, 50_000L),
    MATCH_FIVE_NUMBERS(5, true, 1_500_000L),
    MATCH_SIX_NUMBERS(6, true, 2_000_000_000L);

    private final int numberOfMatches;
    private final boolean isWinning;
    private final long payout;

    LottoResult(int numberOfMatches, boolean isWinning, long payout) {
        this.numberOfMatches = numberOfMatches;
        this.isWinning = isWinning;
        this.payout = payout;
    }

    public long payout() {
        return payout;
    }

    public static LottoResult of(int numberOfMatches) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.numberOfMatches == numberOfMatches)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("로또 당첨 번호 갯수는 0 이상 6 이하의 정수: " + numberOfMatches));
    }
}
