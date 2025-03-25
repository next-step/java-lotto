package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rewards {
    private final List<Reward> values;

    public Rewards(List<Reward> values) {
        this.values = values;
    }

    public Map<Integer, Integer> getMatchCounts() {
        Map<Integer, Integer> result = new HashMap<>();
        for (Reward reward : this.values) {
            reward.applyMatchCount(result);
        }
        return result;
    }

    public double getRateOfReturn(int initialAmount) {
        Long totalPrize = 0L;
        for (Reward reward : this.values) {
            totalPrize += reward.calculatePrize();
        }
        return (double) totalPrize / initialAmount;
    }
}
