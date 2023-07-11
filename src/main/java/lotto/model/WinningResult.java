package lotto.model;

import java.util.Map;
import java.util.function.ToDoubleFunction;

public class WinningResult {
    private final Map<Rank, Integer> winningResult;

    WinningResult(final Map<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public int getRankCount(final Rank rank) {
        return winningResult.get(rank);
    }

    public double calculateProfit(final LottoMoney gain) {
        double sum = winningResult.keySet().stream()
                .mapToDouble(getRankRewards())
                .sum();
        int lottoMoney = gain.getLottoMoney();
        return sum / lottoMoney;
    }

    private ToDoubleFunction<Rank> getRankRewards() {
        return rank -> rank.getReward() * winningResult.get(rank);
    }
}
