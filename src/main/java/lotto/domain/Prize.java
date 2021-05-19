package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    public static final String NOT_FOUND_MATCH_RESULT = "일치하는 결과값이 없습니다.";
    private final int matchCount;
    private final int rewardPrice;

    Prize(int matchCount, int rewardPrice) {
        this.matchCount = matchCount;
        this.rewardPrice = rewardPrice;
    }

    public static Prize findByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MATCH_RESULT));
    }

    public int calculateProfit(int count) {
        return this.rewardPrice * count;
    }
}
