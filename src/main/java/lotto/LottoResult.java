package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.views.ROLottoResult;

public class LottoResult implements ROLottoResult {

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

  @Override
  public int getNumRanks() {
    return Rank.values().length;
  }

  @Override
  public Rank getRank(int i) {
    return Arrays.asList(Rank.values()).get(i);
  }

  @Override
  public int getCount(Rank rank) {
    return this.hitHistory.get(rank);
  }
}
