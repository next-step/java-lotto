package lotto.domain;

import java.util.Arrays;

/**
 * Created by yusik on 2019/11/05.
 */
public enum WinningRanking {

    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    private final int matchingCount;
    private final int reward;

    WinningRanking(int matchingCount, int reward) {
        this.matchingCount = matchingCount;
        this.reward = reward;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getReward() {
        return reward;
    }

    public static WinningRanking getByMatchingCount(long matchingCount) {
        return Arrays.stream(WinningRanking.values())
                .filter(winningRanking -> winningRanking.matchingCount == matchingCount)
                .findFirst()
                .orElse(null);
    }
}
