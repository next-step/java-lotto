package lotto.util;

import java.util.Arrays;

public enum RewardTable {

    FOURTH_RANK(3, 5000),
    THIRD_RANK(4, 50000),
    SECOND_RANK(5, 150000),
    FIRST_RANK(6, 2000000000);


    private int matchRank;
    private int reward;

    RewardTable(int matchRank, int reward) {
        this.matchRank = matchRank;
        this.reward = reward;
    }

    public static RewardTable of(int matchNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchRank == matchNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 등수입니다"));
    }

    public int matchReward(int times) {
        return this.reward * times;
    }

    public int getReward() {
        return this.reward;
    }
}
