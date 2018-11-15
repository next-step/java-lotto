package domain;

import java.util.Arrays;

public enum Rank {

    FIRST                           (6, 2_000_000_000),
    SECOND                          (5, 1_500_000),
    THIRD                           (4, 5_0000),
    FOURTH                          (3, 5_000),
    ETC                             (0, 0);

    private int matchCount;
    private int rewardMoney;

    private Rank(int matchCount, int rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static Rank findRankBy(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(ETC);
    }
}