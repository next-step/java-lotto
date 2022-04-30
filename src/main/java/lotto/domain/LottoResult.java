package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class LottoResult {

  private final Map<Rank, Integer> value;

  public LottoResult(Map<Rank, Integer> value) {
    this.value = value;
  }

  public Map<Rank, Integer> getValue() {
    return Collections.unmodifiableMap(value);
  }

  public int getRankCount(Rank rank) {
    return value.getOrDefault(rank, 0);
  }

  public double calculateYield(PurchaseAmount amount) {
    int sum = 0;
    for (Map.Entry<Rank, Integer> entry : value.entrySet()) {
      sum += entry.getKey().getPrizeMoney() * entry.getValue();
    }
    return amount.getYield(sum);
  }
}
