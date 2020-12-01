package step2;

import java.util.Arrays;

public enum RewardBoard {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private final int matchCnt;
    private final int reward;

    private RewardBoard(int matchCnt, int reward) {
        this.matchCnt = matchCnt;
        this.reward = reward;
    }

    public int getMatchCnt() {
        return this.matchCnt;
    }

    public int getReward() {
        return this.reward;
    }

    public static RewardBoard getReward(int inputMatchCnt) {
        return Arrays.stream(values()).filter(reward -> reward.matchCnt == inputMatchCnt).findFirst().orElse(RewardBoard.MISS);
    }
}
