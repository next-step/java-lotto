package com.lotto.type;

public enum RewardType {
    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 150000), SIX(6, 2000000000);

    private int numberOfCorrect;
    private int price;

    RewardType(int numberOfCorrect, int price) {
        this.numberOfCorrect = numberOfCorrect;
        this.price = price;
    }

    public int getNumberOfCorrect() {
        return numberOfCorrect;
    }

    public static int getRewardValue(int numberOfCorrect) {
        for (RewardType rewardType : RewardType.values()) {
            if (rewardType.numberOfCorrect == numberOfCorrect) {
                return rewardType.price;
            }
        }

        return 0;
    }
}
