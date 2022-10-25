package lotto.model;

import lotto.model.enumeration.Rank;

import java.util.Map;

public class Profit {

    public Profit() {
        throw new AssertionError();
    }

    public static double getReturnRate(Map<Rank, Long> lotteriesRank, int purchaseAmount) {
        double totalAmount = lotteriesRank.entrySet().stream()
                .mapToLong((rank) -> rank.getKey().getWinningMoney() * rank.getValue())
                .sum();

        return totalAmount / purchaseAmount;
    }
}