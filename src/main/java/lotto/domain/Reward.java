package lotto.domain;

public enum Reward {

    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchingCount;
    private final int reward;

    Reward(int matchingCount, int reward) {
        this.matchingCount = matchingCount;
        this.reward = reward;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getReward() {
        return reward;
    }

    public static Reward fromMatchingCount(int matchingCount) {
        for (Reward reward : Reward.values()) {
            if (reward.getMatchingCount() == matchingCount) {
                return reward;
            }
        }
        return null; // or throw an exception
    }

}
