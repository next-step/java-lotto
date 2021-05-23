package com.lotto.domain;

public enum LottoReward {
    THREE(5000) {
        @Override
        public int totalReward(int count) { return count * THREE.reward(); }
    },
    FOUR(50000) {
        @Override
        public int totalReward(int count) { return count * FOUR.reward(); }
    },
    FIVE(1500000) {
        @Override
        public int totalReward(int count) { return count * FIVE.reward(); }
    },
    SIX(2000000000) {
        @Override
        public int totalReward(int count) { return count * SIX.reward(); }
    },
    NOTHING(0) {
        @Override
        public int totalReward(int count) { return 0; }
    };

    private int reward;

    LottoReward(int reward) {
        this.reward = reward;
    }

    public int reward() {
        return reward;
    }

    public abstract int totalReward(int count);

    public static LottoReward generateReward(int sameCount) {
        if (sameCount == 3) {
            return THREE;
        } else if (sameCount == 4) {
            return FOUR;
        } else if (sameCount == 5) {
            return FIVE;
        } else if (sameCount == 6) {
            return SIX;
        }
        return NOTHING;
    }
}
