package com.lotto.domain;

public enum LottoReward {
    FIRST(2_000_000_000) {
        @Override
        public int totalReward(int count) { return count * FIRST.reward(); }
    },
    SECOND(1_500_000) {
        @Override
        public int totalReward(int count) { return count * SECOND.reward(); }
    },
    THIRD(50_000) {
        @Override
        public int totalReward(int count) { return count * THIRD.reward(); }
    },
    FOURTH(5_000) {
        @Override
        public int totalReward(int count) { return count * FOURTH.reward(); }
    },
    MISS(0) {
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

    @Override
    public String toString() {
        if (this == FOURTH) {
            return "3";
        } else if (this == THIRD) {
            return "4";
        } else if (this == SECOND) {
            return "5";
        } else if (this == FIRST) {
            return "6";
        }

        return "0";
    }
}
