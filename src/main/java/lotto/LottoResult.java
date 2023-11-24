package lotto;

import lotto.enums.Rank;

import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<Rank, Integer> winningCountPerRank;
    private final double rateOfReturn;

    public LottoResult(EnumMap<Rank, Integer> winningCountPerRank, double rateOfReturn) {
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
