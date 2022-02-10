package lotto.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    MISS(0, 0);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank getRank(final int matchCount, final boolean containBonusBall) {
        if (matchCount == THIRD.matchCount && containBonusBall) {
            return SECOND;
        }
        if (matchCount < FIFTH.matchCount) {
            return MISS;
        }
        return Arrays.stream(values()).filter(rating -> rating.matchCount == matchCount).findAny()
            .orElseThrow(NoSuchElementException::new);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

}
