package lotto;

import lotto.LottoRule.WINNING_VALUE;

import java.util.List;

public class BuyerResult {
    private List<WINNING_VALUE> winningResult;
    private double profitRate;

    public BuyerResult(List<WINNING_VALUE> winningResult, double profitRate) {
        this.winningResult = winningResult;
        this.profitRate = profitRate;
    }

    public List<WINNING_VALUE> getWinningResult() {
        return winningResult;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
