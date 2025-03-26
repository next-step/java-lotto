package lotto.domain;

import lotto.enums.Rank;

import java.util.List;

public class Rewards {
    private final List<Rank> values;

    public Rewards(List<Rank> values) {
        this.values = values;
    }

    public int getMatchCountsByRank(Rank rank) {
        return (int) this.values.stream().filter(value -> value == rank).count();
    }

    public double getRateOfReturn(int initialAmount) {
        return this.values.stream().mapToLong(Rank::getWinningMoney).sum() / (double) initialAmount;
    }
}
