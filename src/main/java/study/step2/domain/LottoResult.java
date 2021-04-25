package study.step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

  private final Map<Rank, Integer> rankMap;

  public LottoResult() {
    this.rankMap = new HashMap<>();
    rankMap.put(Rank.FIRST, 0);
    rankMap.put(Rank.SECOND, 0);
    rankMap.put(Rank.THIRD, 0);
    rankMap.put(Rank.FOURTH, 0);
  }

  public void add(Rank rank) {
    if (rankMap.containsKey(rank)) {
      rankMap.put(rank, rankMap.get(rank) + 1);
    }
  }

  public Map<Rank, Integer> getRankMap() {
    return rankMap;
  }

  public Integer getValue(Rank rank) {
    return this.rankMap.get(rank);
  }

  public double calculateYield(int money) {
    int totalPrizeMoney = rankMap.keySet().stream()
        .filter(rank -> rank.getMatchCount() > 0)
        .mapToInt(rank -> rankMap.get(rank) * rank.getPrizeMoney())
        .sum();

    return totalPrizeMoney / (double) money;
  }

}
