package com.lotto.domain;

public enum LottoReward {
    FIRST(6, 2_000_000_000) {
        @Override
        public int totalReward(int count) { return count * FIRST.reward(); }
    },
    SECOND(5, 1_500_000) {
        @Override
        public int totalReward(int count) { return count * SECOND.reward(); }
    },
    THIRD(4, 50_000) {
        @Override
        public int totalReward(int count) { return count * THIRD.reward(); }
    },
    FOURTH(3, 5_000) {
        @Override
        public int totalReward(int count) { return count * FOURTH.reward(); }
    },
    MISS(0, 0) {
        @Override
        public int totalReward(int count) { return 0; }
    };

    private int reward;
    private int sameCount;

    LottoReward(int sameCount, int reward) {
        this.reward = reward;
        this.sameCount = sameCount;
    }

    public int reward() {
        return reward;
    }

    public int sameCount() { return sameCount; }

    public abstract int totalReward(int count);

    public static LottoReward generateReward(int sameCount) {
        if (sameCount == 3) {
            return FOURTH;
        } else if (sameCount == 4) {
            return THIRD;
        } else if (sameCount == 5) {
            return SECOND;
        } else if (sameCount == 6) {
            return FIRST;
        }
        return MISS;
    }
}
