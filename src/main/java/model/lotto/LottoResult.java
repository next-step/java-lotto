package model.lotto;

import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<Rank, Integer> totalRank;
    private final int totalPrice;
    private final Price payAmount;
    private static final int ZERO_COUNT = 0;

    public LottoResult(EnumMap<Rank, Integer> totalRank, Price payAmount) {
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
        return payAmount.getPercentOf(totalPrice);
    }

    public static LottoResult of(WinningLotto winningLotto, Lottos paidLottoList, Price payAmount) {
        EnumMap<Rank, Integer> totalRank = paidLottoList.countWinningNumbers(winningLotto);
        return new LottoResult(totalRank, payAmount);
    }
}
