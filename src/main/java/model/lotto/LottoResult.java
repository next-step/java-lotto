package model.lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private final EnumMap<Rank, Integer> totalRank;
    private final int totalPrice;
    private final int payAmount;
    private static final int ZERO_COUNT = 0;

    public LottoResult(EnumMap<Rank, Integer> totalRank, int payAmount) {
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
        EnumMap<Rank, Integer> totalRank = paidLottoList.stream()
                .map(paidLotto -> paidLotto.countWinningNumbers(winningLotto))
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> 1,
                        Integer::sum,
                        () -> new EnumMap<>(Rank.class)
                ));
        return new LottoResult(totalRank, payAmount);
    }
}
