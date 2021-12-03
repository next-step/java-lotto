package domain;

import java.util.Objects;

public class Prize {
    public static final int FIFTH_PRIZE_MATCHING_NUMBER = 3;
    public static final int FOURTH_PRIZE_MATCHING_NUMBER = 4;
    public static final int THIRD_PRIZE_MATCHING_NUMBER = 5;
    public static final int FIRST_PRIZE_MATCHING_NUMBER = 6;
    public static final int FIFTH_PRIZE_REWARD = 5_000;
    public static final int FOURTH_PRIZE_REWARD = 50_000;
    public static final int THIRD_PRIZE_REWARD = 1_500_000;
    public static final int FIRST_PRIZE_REWARD = 2_000_000_000;

    private final PrizeCondition prizeCondition;
    private final int count;

    public Prize(PrizeCondition prizeCondition, int count) {
        this.prizeCondition = prizeCondition;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int profit() {
        return count * prizeCondition.getReward();
    }

    public Prize incrementedPrize() {
        return new Prize(prizeCondition, count + 1);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Prize prize = (Prize) object;

        return count == prize.count && prizeCondition == prize.prizeCondition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeCondition, count);
    }
}
