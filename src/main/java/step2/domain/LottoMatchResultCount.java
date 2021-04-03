package step2.domain;

import step2.exception.IllegalLottoResultCount;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoMatchResultCount {
    THREE(3,
            (matchedCount) -> 5_000),
    FOUR(4,
            (matchedCount) -> 50_000),
    FIVE(5,
            (matchedCount) -> 1_500_000),
    SIX(6,
            (matchedCount) -> 2_000_000_000);

    private int matchCount;
    private Function<Long, Integer> matchResultsMessage;

    LottoMatchResultCount(
            int matchCount,
            Function<Long, Integer> matchResultsMessage) {
        this.matchCount = matchCount;
        this.matchResultsMessage = matchResultsMessage;
    }

    public static LottoMatchResultCount of(int matchCount) {
        return Arrays.stream(values())
                .filter(priceEnum -> priceEnum.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalLottoResultCount("잘못된 입력값입니다."));
    }

    public int getRewardCash(long matchedCount) {
        return matchResultsMessage.apply(matchedCount);
    }

}
