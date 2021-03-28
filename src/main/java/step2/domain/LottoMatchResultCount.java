package step2.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum LottoMatchResultCount {
    THREE(3,
            (matchedCount) -> "3개 일치 (5000원)-" + matchedCount + "개",
            (matchedCount) -> 5000 * matchedCount),
    FOUR(4,
            (matchedCount) -> "4개 일치 (50000원)-" + matchedCount + "개",
            (matchedCount) -> 50000 * matchedCount),
    FIVE(5,
            (matchedCount) -> "5개 일치 (1500000원)-" + matchedCount + "개",
            (matchedCount) -> 1500000 * matchedCount),
    SIX(6,
            (matchedCount) -> "6개 일치 (2000000000원)-" + matchedCount + "개",
            (matchedCount) -> 2000000000 * matchedCount);

    private int matchCount;
    private Function<Long, String> matchResultsMessage;
    private Function<Long, Long> lottoBenefitMessage;

    LottoMatchResultCount(
            int matchCount,
            Function<Long, String> matchResultsMessage,
            Function<Long, Long> lottoBenefitMessage) {
        this.matchCount = matchCount;
        this.matchResultsMessage = matchResultsMessage;
        this.lottoBenefitMessage = lottoBenefitMessage;
    }

    public static LottoMatchResultCount of(int matchCount) {
        return Arrays.stream(LottoMatchResultCount.values())
                .filter(priceEnum -> priceEnum.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력값 입니다."));
    }

    public String getMatchResultsMessage(long matchedCount) {
        return matchResultsMessage.apply(matchedCount);
    }

    public long getBenefit(long matchedCount) {
        return lottoBenefitMessage.apply(matchedCount);
    }
}