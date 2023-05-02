package lotto.dto;

import lotto.enums.Rank;

import java.util.Map;

public class WinningResult {
    Map<Rank, Integer> rankCount;
    double totalReturn;


    public WinningResult(Map<Rank, Integer> rankCount, double totalReturn) {
        this.rankCount = rankCount;
        this.totalReturn = totalReturn;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double getTotalReturn() {
        return totalReturn;
    }

}
