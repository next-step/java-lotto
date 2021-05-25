package com.lotto.domain;

import java.util.Arrays;

public enum LottoReward {
    FIRST(6, false, 2_000_000_000) {
        @Override
        public int totalReward(int count) {
            return count * FIRST.reward();
        }
    },
    SECOND_BONUS(5, true, 3_000_000) {
        @Override
        public int totalReward(int count) {
            return count * SECOND_BONUS.reward();
        }
    },
    SECOND(5, false, 1_500_000) {
        @Override
        public int totalReward(int count) {
            return count * SECOND.reward();
        }
    },
    THIRD(4, false, 50_000) {
        @Override
        public int totalReward(int count) {
            return count * THIRD.reward();
        }
    },
    FOURTH(3, false, 5_000) {
        @Override
        public int totalReward(int count) {
            return count * FOURTH.reward();
        }
    },
    MISS(0, false, 0) {
        @Override
        public int totalReward(int count) {
            return 0;
        }
    };

    private int reward;
    private int sameCount;
    private boolean isBonus;

    LottoReward(int sameCount, boolean isBonus, int reward) {
        this.reward = reward;
        this.isBonus = isBonus;
        this.sameCount = sameCount;
    }

    public int reward() {
        return reward;
    }

    public int sameCount() {
        return sameCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public abstract int totalReward(int count);

    public static LottoReward generateReward(int sameCount) {
        return Arrays.stream(values())
                .filter(reward -> reward.sameCount() == sameCount && !reward.isBonus())
                .findFirst()
                .orElse(MISS);
    }
}
