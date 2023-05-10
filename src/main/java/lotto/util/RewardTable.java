package lotto.util;

import java.util.Arrays;

public enum RewardTable {

    MISS(0, false, 0L),
    FIFTH_RANK(3, false, 5_000L),
    FOURTH_RANK(4, false, 50_000L),
    THIRD_RANK(5, false, 1_500_000L),
    SECOND_RANK(5, true, 30_000_000L),
    FIRST_RANK(6, false, 2_000_000_000L);

    private int matchCount;
    private Boolean matchBonus;
    private Long reward;

    RewardTable(int matchCount, Boolean matchBonus, Long reward) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.reward = reward;
    }

    public static RewardTable of(int matchCount, Boolean matchBonus) {
        return Arrays.stream(RewardTable.values())
                .filter(rank -> rank.getRank(matchCount, matchBonus))
                .findAny()
                .orElse(RewardTable.MISS)
                ;
    }

    private boolean getRank(int matchCount, Boolean matchBonus) {
        if(matchCount == SECOND_RANK.matchCount) {
            return isBonusMatch(matchCount, matchBonus);
        }
        return this.matchCount == matchCount;
    }

    private boolean isBonusMatch(int matchCount, Boolean matchBonus) {
        return this.matchCount == matchCount && this.matchBonus == matchBonus;
    }

    public Long matchReward(Long times) {
        return this.reward * times;
    }

    public Long getReward() {
        return this.reward;
    }

    public int getMatchCount() {
        return this.matchCount;
    }
}
