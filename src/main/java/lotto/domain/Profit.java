package lotto.domain;

import lotto.domain.type.Rank;

import java.util.List;

public class Profit {
    private final double value;

    public Profit(List<Rank> ranks) {
        int numberOfReward = ranks.size();
        long totalReward = ranks.stream()
                .mapToLong(Rank::winningMoney)
                .sum();

        this.value = totalReward / (Lotto.PRICE * (double) numberOfReward);
    }

    public double value() {
        return value;
    }
}
