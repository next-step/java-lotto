package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank findByMatchCount(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 매치 카운트와 일치하는 등수가 없습니다."));
    }

    public int reward() {
        return this.reward;
    }
}
