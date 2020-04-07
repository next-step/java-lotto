package lotto.domain;

import static lotto.domain.LottoGames.LOTTO_PRICE;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.model.Rank;

public class RankStatistic {

  private Map<Rank, Long> rankStatistic;

  public RankStatistic(List<Rank> ranks) {
    rankStatistic = ranks.stream()
        .collect(
            Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            )
        );
  }

  public double calculateYield() {
    return calculatePrizeMoney() / (double) calculatePurchaseAmount();
  }

  private long calculatePrizeMoney() {
    return rankStatistic.entrySet().stream()
        .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
        .sum();
  }

  private long calculatePurchaseAmount() {
    return rankStatistic.values().stream()
        .mapToLong(v -> v).sum() * LOTTO_PRICE;
  }

  public long countWinsOf(Rank rank) {
    return Optional.ofNullable(rankStatistic.get(rank)).orElse(0L);
  }
}
