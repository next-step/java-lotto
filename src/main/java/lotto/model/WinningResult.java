package lotto.model;

import java.util.Map;
import java.util.function.ToDoubleFunction;

public class WinningResult {

    private final Map<Rank, Integer> winningResult;
    private final double profit;

    public WinningResult(final Map<Rank, Integer> winningResult, final LottoMoney lottoMoney) {
        this.winningResult = winningResult;
        this.profit = calculateProfit(lottoMoney);
    }

    public int getRankCount(final Rank rank) {
        return winningResult.get(rank);
    }

    public double getProfit() {
        return this.profit;
    }

    private double calculateProfit(final LottoMoney lottoMoney) {
        double sum = winningResult.keySet().stream()
            .mapToDouble(getRankRewards())
            .sum();
        return sum / lottoMoney.getLottoMoney();
    }

    private ToDoubleFunction<Rank> getRankRewards() {
        return rank -> rank.getReward() * winningResult.get(rank);
    }
}
