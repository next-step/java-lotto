package lotto.domain;

import java.util.Arrays;

public enum LOTTO_REWARD {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matches;
    private final long reward;

    LOTTO_REWARD(int matches, long reward) {
        this.matches = matches;
        this.reward = reward;
    }

    public static LOTTO_REWARD of(int matches, boolean bonusMatched) {
        LOTTO_REWARD reward = Arrays.stream(LOTTO_REWARD.values()).filter(it -> it.matches == matches)
                .findFirst().orElse(MISS);

        if(matches == 5 && bonusMatched) {
            return SECOND;
        }

        return reward;
    }

    public long getReward() {
        return reward;
    }


}
