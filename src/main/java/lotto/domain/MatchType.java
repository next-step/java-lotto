package lotto.domain;

import java.util.Arrays;

public enum MatchType {
    THREE(3, 5000, "3개 일치 (5000원)", 0),
    FOUR(4, 50000, "4개 일치 (50000원)", 1),
    FIVE(5, 1500000, "5개 일치 (1500000원)", 2),
    SIX(6, 2000000000, "6개 일치 (2000000000원)", 3);

    private final int matchCount;
    private final long reward;
    private final String phrase;
    private final int matchCountIdx;

    MatchType(int matchCount, long reward, String phrase, int matchCountIdx) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.phrase = phrase;
        this.matchCountIdx = matchCountIdx;
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

    public int matchCountIdx() {
        return matchCountIdx;
    }

    public static MatchType of(int matchCount) {
        return Arrays.stream(values())
                .filter(v -> matchCount == v.matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%d는 당첨에 해당하는 번호 일치 개수가 아닙니다.", matchCount)));
    }
}
