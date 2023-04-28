package lotto.domain;

import java.util.Arrays;

public enum RewardType {
    THREE(3, 5000, "3개 일치 (5000원)"),
    FOUR(4, 50000, "4개 일치 (50000원)"),
    FIVE(5, 1500000, "5개 일치 (1500000원)"),
    SIX(6, 2000000000, "6개 일치 (2000000000원)");

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
