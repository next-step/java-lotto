package com.lotto;

public enum LottoReward {
    THREE(5000) {
        @Override
        int totalReward(int count) { return count * THREE.reward(); }
    },
    FOUR(50000) {
        @Override
        int totalReward(int count) { return count * FOUR.reward(); }
    },
    FIVE(1500000) {
        @Override
        int totalReward(int count) { return count * FIVE.reward(); }
    },
    SIX(2000000000) {
        @Override
        int totalReward(int count) { return count * SIX.reward(); }
    },
    NOTHING(0) {
        @Override
        int totalReward(int count) { return 0; }
    };

    private int reward;

    LottoReward(int reward) {
        this.reward = reward;
    }

    public int reward() {
        return reward;
    }

    abstract int totalReward(int count);
}
