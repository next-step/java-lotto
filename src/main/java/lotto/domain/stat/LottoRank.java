package lotto.domain.stat;

import java.util.Arrays;

public enum LottoRank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(-1, 0);

    private final int numberOfMatches;
    private final int reward;

    LottoRank(int numberOfMatches, int reward) {
        this.numberOfMatches = numberOfMatches;
        this.reward = reward;
    }

    public static LottoRank of(int numberOfMatches) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.numberOfMatches == numberOfMatches)
                .findFirst()
                .orElse(NONE);
    }

    public boolean isNotNone() {
        return !this.equals(NONE);
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getReward() {
        return reward;
    }

    public int multiplyCountToReward(int count) {
        return reward * count;
    }

}
