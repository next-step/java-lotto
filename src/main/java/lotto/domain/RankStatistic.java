package lotto.domain;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.domain.LottoGames.LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.model.Rank;

public class RankStatistic {

  private Map<Rank, Long> rankStatistic;

  public RankStatistic(List<Rank> ranks) {
    rankStatistic = ranks.stream()
        .collect(groupingBy(identity(), counting()));
  }

  public double calculateYield() {
    return sumTotalPrizeMoney() / (double) calculatePurchaseAmount();
  }

  private long sumTotalPrizeMoney() {
    return rankStatistic.entrySet()
        .stream()
        .mapToLong(this::sumRankPrizeMoney)
        .sum();
  }

  private long sumRankPrizeMoney(Entry<Rank, Long> entry) {
      Rank rank = entry.getKey();
      long winCount = entry.getValue();
      return rank.getWinningMoney() * winCount;
  }

  private long calculatePurchaseAmount() {
    return rankStatistic.values()
        .stream()
        .reduce(0L, Long::sum)
        * LOTTO_PRICE;
  }

  public long countWinsOf(Rank rank) {
    return rankStatistic.get(rank) != null ? rankStatistic.get(rank) : 0L;
  }
}
