package step2;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FAIL(0, 0);

    private final int matchNumberCount;
    private final int reward;

    Rank(int matchNumberCount, int reward) {
        this.matchNumberCount = matchNumberCount;
        this.reward = reward;
    }

    public static Rank of(int matchNumberCount) {
        return Arrays.stream(Rank.values())
            .filter(i -> i.matchNumberCount == matchNumberCount)
            .findFirst()
            .orElse(FAIL);
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getReward() {
        return reward;
    }
}
