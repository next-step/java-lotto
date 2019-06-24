package camp.nextstep.edu.lotto;

import java.util.Arrays;

public enum RewardType {
    SIX_NUMBERS_MATCHED(6, 2000000000),
    FIVE_NUMBERS_MATCHED(5, 1500000),
    FOUR_NUMBERS_MATCHED(4, 50000),
    THREE_NUMBERS_MATCHED(3, 5000),
    UNKNOWN(0, 0);

    private static final int MINIMUM_SCORE = 0;

    private final int score;
    private final long reward;

    RewardType(int score, int reward) {
        this.score = score;
        this.reward = reward;
    }

    public static RewardType from(int score) {
        if (score < MINIMUM_SCORE) {
            throw new IllegalArgumentException("'score' must be greater than or equal to " + MINIMUM_SCORE);
        }
        return Arrays.stream(RewardType.values())
                .filter(value -> value.score == score)
                .findFirst()
                .orElse(UNKNOWN);
    }

    public long getReward() {
        return reward;
    }
}
