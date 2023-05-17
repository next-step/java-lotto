package lotto.domain;

import java.util.Arrays;

public enum Rank {
    SEVENTH(0, 0),
    SIXTH(1, 0),
    FIFTH(2, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

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

    public int totalReward(int count) {
        return this.reward * count;
    }

    public boolean isWin() {
        return this.reward != 0;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public int reward() {
        return this.reward;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchCount, reward);
    }
}
