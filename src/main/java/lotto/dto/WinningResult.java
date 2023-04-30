package lotto.dto;

import lotto.enums.RANK;

import java.util.Map;

public class WinningResult {
    Map<RANK, Integer> rankCount;
    double totalReturn;


    public WinningResult(Map<RANK, Integer> rankCount, double totalReturn) {
        this.rankCount = rankCount;
        this.totalReturn = totalReturn;
    }

    public Map<RANK, Integer> getRankCount() {
        return rankCount;
    }

    public double getTotalReturn() {
        return totalReturn;
    }

}
