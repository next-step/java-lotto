package camp.nextstep.edu.lotto.domain;

import java.util.Arrays;

public enum RewardType implements BonusResolver {
    SIX_NUMBERS_MATCHED(6, 2_000_000_000) {
        @Override
        public boolean supports(boolean bonus) {
            return true;
        }
    },
    FIVE_NUMBERS_AND_BONUS_MATCHED(5, 30_000_000) {
        @Override
        public boolean supports(boolean bonus) {
            return bonus == true;
        }
    },
    FIVE_NUMBERS_MATCHED(5, 1_500_000) {
        @Override
        public boolean supports(boolean bonus) {
            return bonus == false;
        }
    },
    FOUR_NUMBERS_MATCHED(4, 50_000) {
        @Override
        public boolean supports(boolean bonus) {
            return true;
        }
    },
    THREE_NUMBERS_MATCHED(3, 5_000) {
        @Override
        public boolean supports(boolean bonus) {
            return true;
        }
    },
    UNKNOWN(0, 0) {
        @Override
        public boolean supports(boolean bonus) {
            return true;
        }
    };

    private static final int MINIMUM_SCORE = 0;

    private final int score;
    private final long reward;

    RewardType(int score, int reward) {
        this.score = score;
        this.reward = reward;
    }

    public static RewardType from(int score, boolean bonus) {
        if (score < MINIMUM_SCORE) {
            throw new IllegalArgumentException("'score' must be greater than or equal to " + MINIMUM_SCORE);
        }
        return Arrays.stream(RewardType.values())
                .filter(value -> value.supports(bonus))
                .filter(value -> value.score == score)
                .findFirst()
                .orElse(UNKNOWN);
    }

    public int getScore() {
        return score;
    }

    public long getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return "RewardType{" +
                "score=" + score +
                ", reward=" + reward +
                '}';
    }
}
