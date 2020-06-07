package lotto.domain;

import java.util.*;

public class ProfitStatistics {

    private Map<Prize, Integer> winningList;
    private int money;

    public ProfitStatistics(Map<Prize, Integer> winningList, int money) {
        this.winningList = winningList;
        this.money = money;
    }

    public double getProfitRatio() {
        return (double) calculateProfit() / money;
    }

    private int calculateProfit() {
        int prizeSum = winningList.keySet().stream().mapToInt(this::calculateWinningList).sum();

        return prizeSum;
    }

    private int calculateWinningList(Prize prize) {
        return prize.getWinningPrize() * winningList.get(prize);
    }
}
