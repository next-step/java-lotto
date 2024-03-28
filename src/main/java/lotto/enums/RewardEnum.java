package lotto.enums;

public enum RewardEnum {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchingCount;
    private final int reward;

    RewardEnum(int matchingCount, int reward) {
        this.matchingCount = matchingCount;
        this.reward = reward;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getReward() {
        return reward;
    }

    public static RewardEnum fromMatchingCount(int matchingCount) {
        for (RewardEnum rewardEnum : RewardEnum.values()) {
            if (rewardEnum.getMatchingCount() == matchingCount) {
                return rewardEnum;
            }
        }
        return null; // or throw an exception
    }

}
