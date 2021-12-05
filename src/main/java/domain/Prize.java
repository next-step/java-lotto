package domain;

import java.util.Objects;

public class Prize {

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
