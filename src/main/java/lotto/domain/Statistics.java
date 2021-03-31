package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public final class Statistics {

  private final Map<Ranking, Integer> rankMap;
  private Money winPrice;

  public Statistics() {
    this.rankMap = new HashMap<>();
    this.winPrice = new Money(0);
  }

  public void recordRanking(Ranking ranking) {
    rankMap.computeIfPresent(ranking, (key, value) -> value + 1);
    rankMap.putIfAbsent(ranking, 1);
    winPrice = winPrice.plus(new Money(ranking.getPrize()));
  }

  public Integer countGame(Ranking ranking) {
    return rankMap.getOrDefault(ranking,0);
  }

  public double getEarningRate(Money investMoney) {
    return winPrice.calculateRate(investMoney);
  }
}
