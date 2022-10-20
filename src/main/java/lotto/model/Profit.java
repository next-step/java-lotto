package lotto.model;

import lotto.model.enumeration.Rank;

import java.util.Map;

public class Profit {

    private Map<Rank, Long> lotteriesRank;

    public Profit(Map<Rank, Long> lotteriesRank) {
        this.lotteriesRank = lotteriesRank;
    }

    public long getTotalWinningMoney() {
        return lotteriesRank.entrySet().stream()
                .mapToLong((rank) -> rank.getKey().getWinningMoney() * rank.getValue())
                .sum();
    }
}
