package lotto.domain;

import java.util.Arrays;

public enum RewardType {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_AND_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final long reward;

    RewardType(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int matchCount() {
        return matchCount;
    }

    public long reward() {
        return reward;
    }

    public static RewardType of(int matchCount, boolean isMatchWithBonus) {
        if (FIVE.matchCount() == matchCount && isMatchWithBonus) {
            return FIVE_AND_BONUS;
        }
        return Arrays.stream(values())
                .filter(v -> matchCount == v.matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%d는 당첨에 해당하는 번호 일치 개수가 아닙니다.", matchCount)));
    }
}
