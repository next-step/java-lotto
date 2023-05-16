package lotto.util;

import java.util.Arrays;

public enum RewardTable {

    MISS(0,  0L),
    FIFTH_RANK(3,  5_000L),
    FOURTH_RANK(4,  50_000L),
    THIRD_RANK(5,  1_500_000L),
    SECOND_RANK(5,  30_000_000L),
    FIRST_RANK(6,  2_000_000_000L);

    private int matchCount;
    private long reward;

    RewardTable(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static RewardTable of(int matchCount, Boolean matchBonus) {
        if(matchCount == 5 && matchBonus) {
            return SECOND_RANK;
        }

        return Arrays.stream(RewardTable.values())
                .filter(rank -> {
                    if(matchCount == 5) return rank == THIRD_RANK;
                    return rank.matchCount == matchCount;
                })
                .findFirst()
                .orElse(RewardTable.MISS)
                ;
    }

    public long getRewardByTimes(long times) {
        return this.reward * times;
    }

    public long getReward() {
        return this.reward;
    }

    public int getMatchCount() {
        return this.matchCount;
    }
}
