package com.lotto.type;

import java.util.Arrays;
import java.util.stream.Stream;

public enum RewardType {
    FIRST(6, 2000000000, false)
    , SECOND(5, 30000000, true)
    , THIRD(5, 1500000, false)
    , FOURTH(4, 50000, false)
    , FIFTH(3, 5000, false)
    , MISS(0, 0, false);

    private int numberOfCorrect;
    private int price;
    private boolean isBonusNumber;


    RewardType(int numberOfCorrect, int price, boolean isBonusNumber) {
        this.numberOfCorrect = numberOfCorrect;
        this.price = price;
        this.isBonusNumber = isBonusNumber;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }

    public int getNumberOfCorrect() {
        return numberOfCorrect;
    }

    public static RewardType getRewardType(int numberOfCorrect, boolean isBonusNumber) {
        for (RewardType rewardType : RewardType.values()) {
            if (rewardType.numberOfCorrect == numberOfCorrect && rewardType.isBonusNumber == isBonusNumber) {
                return rewardType;
            }
        }

        return RewardType.MISS;
    }

    public static Stream<RewardType> streamExceptMiss() {
        return Arrays.stream(RewardType.values()).filter(rewardType -> RewardType.MISS != rewardType);
    }
}
