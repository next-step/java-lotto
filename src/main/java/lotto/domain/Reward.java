package lotto.domain;

import lotto.domain.type.Rank;

import java.util.List;

public class Reward {
    private final int numberOfReward;
    private final long value;

    public Reward(List<Rank> ranks) {
        long result = 0;
        for (Rank rank : ranks) {
            result += rank.winningMoney();
        }

        this.value = result;
        this.numberOfReward = ranks.size();
    }

    public long value() {
        return value;
    }

    public int numberOfReward() {
        return numberOfReward;
    }

    public boolean isNone() {
        return value == 0;
    }
}
