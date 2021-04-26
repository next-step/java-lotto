package study.step2.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

  private final Map<Rank, Integer> rankMap = new HashMap<>();

  public LottoResult() {
    Arrays.stream(Rank.values()).forEach(rank -> rankMap.put(rank, 0));
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
    return rankMap.get(rank);
  }

  public double calculateYield(int money) {
    int totalPrizeMoney = rankMap.keySet().stream()
        .filter(rank -> rank.getMatchCount() > 0)
        .mapToInt(rank -> rankMap.get(rank) * rank.getPrizeMoney())
        .sum();

    return totalPrizeMoney / (double) money;
  }

}
