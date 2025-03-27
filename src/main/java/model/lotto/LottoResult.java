package model.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> totalRank;
    private final int totalPrice;
    private final int payAmount;
    private static final int ZERO_COUNT = 0;

    public LottoResult(Map<Rank, Integer> totalRank, int payAmount) {
        this.totalRank = totalRank;
        this.totalPrice = totalRank.entrySet().stream()
                .mapToInt(rank -> rank.getKey().getWinningPrice() * rank.getValue())
                .sum();
        this.payAmount = payAmount;
    }

    public int getRankCount(Rank rank) {
        return totalRank.getOrDefault(rank, ZERO_COUNT);
    }

    public double getTotalProfitPercent() {
        return (double) totalPrice / this.payAmount;
    }

    public static LottoResult of(WinningLotto winningLotto, List<Lotto> paidLottoList, int payAmount) {
        Map<Rank, Integer> totalRank = new HashMap<>();
        for (Lotto paidLotto : paidLottoList) {
            Rank rank = paidLotto.countWinningNumbers(winningLotto);
            totalRank.put(rank, totalRank.getOrDefault(rank, ZERO_COUNT) + 1);
        }
        return new LottoResult(totalRank, payAmount);
    }
}
