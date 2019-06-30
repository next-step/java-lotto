package lotto.model;

import java.util.*;

public class Statistics {
    private Map<Rank, Integer> results;

    public Statistics() {
        results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.putIfAbsent(rank, 0);
        }
    }

    public void put(Rank rank) {
        int countOfRank = results.getOrDefault(rank, 0);
        results.put(rank, countOfRank + 1);
    }

    public int getCountOfWinning(Rank rank) {
        return results.get(rank);
    }

    public double calculateProfitRate(Money investment) {
        Money totalWinningMoney = calculateTotalWinningMoney();
        return totalWinningMoney.percentageBy(investment) / Money.PERCENTAGE_RATIO;
    }

    private Money calculateTotalWinningMoney() {
        Money totalWinningMoney = Money.valueOf(0);
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int numberOfWinning = entry.getValue();

            Money winningMoney = rank.getWinningMoney(numberOfWinning);
            totalWinningMoney = totalWinningMoney.add(winningMoney);
        }

        return totalWinningMoney;
    }
}
