package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

  private final Map<Rank, Integer> hitHistory;

  public LottoResult() {
    this.hitHistory = new HashMap<>();

    Arrays.stream(Rank.values())
        .forEach(rank -> this.hitHistory.put(rank, 0));
  }

  public int calculateIncome() {
    return Rank.calculateTotalReward(hitHistory);
  }

  public void recordHit(Rank rank) {
    this.hitHistory.put(rank, this.hitHistory.get(rank) + 1);
  }
}
