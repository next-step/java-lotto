package lotto.domain;

import lotto.enums.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rewards {
    private final List<Rank> values;

    public Rewards(List<Rank> values) {
        this.values = values;
    }

    public Map<Rank, Integer> getMatchCounts() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : this.values) {
            rank.applyMatchCount(result);
        }
        return result;
    }

    public double getRateOfReturn(int initialAmount) {
        return this.values.stream().mapToLong(Rank::getWinningMoney).sum() / (double) initialAmount;
    }
}
