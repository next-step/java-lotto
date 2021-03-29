package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.view.StatisticsDto;

public final class Statistics {

  private final Map<Ranking, Integer> rankMap;
  private Money winPrice;

  public Statistics() {
    this.rankMap = new HashMap<>();
    this.winPrice = new Money(0);
  }

  public void recordRanking(Ranking ranking) {
    rankMap.computeIfPresent(ranking, (key, value) -> value + 1);
    rankMap.computeIfAbsent(ranking, key -> 1);
    winPrice = winPrice.plus(new Money(ranking.getPrize()));
  }

  public Integer countGame(StatisticsDto statisticsDto) {
    Integer count = rankMap.get(statisticsDto.getRanking());
    if (count == null) {
      return 0;
    }
    return count;
  }

  public double getEarningRate(Money investMoney) {
    return winPrice.calculateRate(investMoney);
  }
}
