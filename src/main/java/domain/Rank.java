package domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {

    FIRST                           (6, 2_000_000_000),
    SECOND                           (5,   30_000_000),
    THIRD                            (5,    1_500_000),
    FOURTH                           (4,       50_000),
    FIFTH                            (3,        5_000),
    ETC                              (0,            0);

    private int matchCount;
    private int rewardMoney;

    Rank(int matchCount, int rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static Rank findRankBy(int matchCount, boolean bonusYn) {
        List<Rank> originRanks = Arrays.asList(FIRST, THIRD, FOURTH, FIFTH);

        for (Rank rank : originRanks) {
            if (rank.matchCount == matchCount) {
                if(rank == THIRD && bonusYn )
                    return SECOND;

                return rank;
            }
        }
        return ETC;
    }

    public long calculateRankSum(Long amount) {
        return getRewardMoney() * amount;
    }
}