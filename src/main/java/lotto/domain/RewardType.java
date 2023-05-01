package lotto.domain;

import java.util.Arrays;

public enum RewardType {
    THREE(3, 5_000, "3개 일치 (5000원)"),
    FOUR(4, 50_000, "4개 일치 (50000원)"),
    FIVE(5, 1_500_000, "5개 일치 (1500000원)"),
    FIVE_AND_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    SIX(6, 2_000_000_000, "6개 일치 (2000000000원)");

    private final int matchCount;
    private final long reward;
    private final String phrase;

    RewardType(int matchCount, long reward, String phrase) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.phrase = phrase;
    }

    public int matchCount() {
        return matchCount;
    }

    public long reward() {
        return reward;
    }

    public String phrase() {
        return phrase;
    }


    public static RewardType of(int matchCount) {
        return Arrays.stream(values())
                .filter(v -> matchCount == v.matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%d는 당첨에 해당하는 번호 일치 개수가 아닙니다.", matchCount)));
    }
}
