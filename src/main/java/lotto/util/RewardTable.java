package lotto.util;

import java.util.Arrays;

public enum RewardTable {

    FIFTH_RANK(3, null, 5_000),
    FOURTH_RANK(4, null, 50_000),
    THIRD_RANK(5, false, 1_500_000),
    SECOND_RANK(5, true, 30_000_000),
    FIRST_RANK(6, null, 2_000_000_000);

    private int matchRank;
    private Boolean matchBonus;
    private int reward;

    RewardTable(int matchRank, Boolean matchBonus, int reward) {
        this.matchRank = matchRank;
        this.matchBonus = matchBonus;
        this.reward = reward;
    }

    public static RewardTable of(int matchNumber, Boolean matchBonus) {
        return Arrays.stream(RewardTable.values())
                .filter(rank -> rank.getRank(matchNumber, matchBonus))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 등수입니다"))
                ;
    }

    private boolean getRank(int matchCount, Boolean matchBonus) {
        if(matchBonus != null) {
            return isBonusMatch(matchCount, matchBonus);
        }
        return this.matchRank == matchCount;
    }

    private boolean isBonusMatch(int matchCount, Boolean matchBonus) {
        return this.matchRank == matchCount && this.matchBonus == matchBonus;
    }

    public int matchReward(int times) {
        return this.reward * times;
    }

    public int getReward() {
        return this.reward;
    }

    public int getMatchRank() {
        return this.matchRank;
    }
}
