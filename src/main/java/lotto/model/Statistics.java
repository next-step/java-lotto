package lotto.model;

import java.util.*;

public class Statistics {
    private static final int INITIAL_COUNTING_VALUE = 0;
    private static final int INITIAL_MONEY = 0;
    private static final int COUNTING_UNIT = 1;
    private Map<Rank, Integer> results;

    public Statistics() {
        results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.putIfAbsent(rank, INITIAL_COUNTING_VALUE);
        }
    }

    public void put(Rank rank) {
        int countOfRank = results.getOrDefault(rank, INITIAL_COUNTING_VALUE);
        results.put(rank, countOfRank + COUNTING_UNIT);
    }

    public int getCountOfWinning(Rank rank) {
        return results.get(rank);
    }

    public double calculateProfitRate(Money investment) {
        Money totalWinningMoney = calculateTotalWinningMoney();
        return totalWinningMoney.percentageBy(investment) / Money.PERCENTAGE_RATIO;
    }

    private Money calculateTotalWinningMoney() {
        Money totalWinningMoney = Money.valueOf(INITIAL_MONEY);
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            int numberOfWinning = entry.getValue();

            Money winningMoney = rank.getWinningMoney(numberOfWinning);
            totalWinningMoney = totalWinningMoney.add(winningMoney);
        }
        return totalWinningMoney;
    }
}
