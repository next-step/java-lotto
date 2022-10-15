package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private int matchCount;
    private int reward;

    private Rank(final int matchCount, final int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank getRank(final int matchCount) {
        if (matchCount < FOURTH.matchCount) {
            return MISS;
        }

        return Arrays.stream(values()).filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getReward() {
        return reward;
    }
}
