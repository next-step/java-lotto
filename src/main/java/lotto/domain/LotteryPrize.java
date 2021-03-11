package lotto.domain;

public enum LotteryPrize {

    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3);

    private int reward;

    private int matchingCount;

    LotteryPrize(int reward, int matchingCount) {
        this.reward = reward;
        this.matchingCount = matchingCount;
    }

    public int getReward() {
        return reward;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
