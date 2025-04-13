package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningSummary {

  private final Map<PRIZES, Integer> prizeCountMap = new HashMap<>();

  public void add(PRIZES prize) {
    prizeCountMap.put(prize, prizeCountMap.getOrDefault(prize, 0) + 1);
  }

  public int getCount(PRIZES prize) {
    return prizeCountMap.getOrDefault(prize, 0);
  }

  public long calculateTotalWinning() {
    return prizeCountMap.entrySet().stream()
        .mapToLong(entry -> entry.getKey().calculatePrizeAmount(entry.getValue()))
        .sum();
  }
}
