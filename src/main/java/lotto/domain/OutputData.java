package lotto.domain;

import lotto.enums.Rank;

import java.util.Map;

public class OutputData {

    private Money expense;
    private Map<Rank, Integer> rankMap;

    public OutputData(Map<Rank, Integer> rankMap, Money expense) {
        this.rankMap = rankMap;
        this.expense = expense;
    }

    public float calculateWinRate() {
        return sumWinAmount() / this.expense.won();
    }

    public Map<Rank, Integer> rankMap() {
        return this.rankMap;
    }

    private int sumWinAmount() {
        int sumAmount = 0;
        for (Rank rank : rankMap.keySet()) {
            sumAmount += rank.getWinningMoney() * rankMap.get(rank);
        }
        return sumAmount;
    }

}
