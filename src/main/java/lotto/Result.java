package lotto;

import lotto.enums.Rank;

import java.util.EnumMap;

public class Result {
    private final EnumMap<Rank, Integer> winningCountPerRank;
    private final double rateOfReturn;

    public Result(EnumMap<Rank, Integer> winningCountPerRank, double rateOfReturn) {
        this.winningCountPerRank = winningCountPerRank;
        this.rateOfReturn = rateOfReturn;
    }

    public EnumMap<Rank, Integer> getWinningCountPerRank() {
        return winningCountPerRank;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
