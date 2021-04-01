package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Statistics {

  private final Map<Ranking, Integer> rankMap;

  public Statistics() {
    this.rankMap = new HashMap<>();
  }

  public void recordRanking(Ranking ranking) {
    rankMap.computeIfPresent(ranking, (key, value) -> value + 1);
    rankMap.putIfAbsent(ranking, 1);
  }

  public Integer countGame(Ranking ranking) {
    return rankMap.getOrDefault(ranking,0);
  }

  public double getEarningRate(Money investMoney) {
    Set<Ranking> rankings = rankMap.keySet();
    Money totalPrize = rankings.stream()
        .map(ranking -> new Money(ranking.getPrize()).multiply(rankMap.get(ranking)))
        .reduce(new Money(0), Money::plus);
    return totalPrize.calculateRate(investMoney);
  }
}
