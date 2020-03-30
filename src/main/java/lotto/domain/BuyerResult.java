package lotto.domain;

import java.util.List;

public class BuyerResult {
    private final List<Rank> winningResult;
    private final double profitRate;

    public BuyerResult(List<Rank> ranks, int lottoCount) {
        this.winningResult = ranks;
        this.profitRate = calculateProfitRate(lottoCount);
    }

    private double calculateProfitRate(int lottoCount) {
        long winningAmountSum = getWinningAmountSum();
        double profitRate = ((double) winningAmountSum) / (lottoCount * LottoTicket.PRICE);
        return Math.round(profitRate * 100) / 100.0;
    }

    private long getWinningAmountSum() {
        return winningResult.stream()
                .mapToLong(Rank::getAmount)
                .sum();
    }

    public List<Rank> getWinningResult() {
        return winningResult;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
