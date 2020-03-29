package lotto.domain;

import java.util.List;

public class BuyerResult {
    private List<Rank> winningResult;
    private double profitRate;

    public BuyerResult(List<Rank> winningResult, double profitRate) {
        this.winningResult = winningResult;
        this.profitRate = profitRate;
    }

    public List<Rank> getWinningResult() {
        return winningResult;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
