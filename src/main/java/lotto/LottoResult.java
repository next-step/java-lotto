package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.views.ReadOnlyLottoResult;

public class LottoResult implements ReadOnlyLottoResult {

  private final Map<Rank, Integer> hitHistory;

  public LottoResult() {
    this.hitHistory = new HashMap<>();

    Arrays.stream(Rank.values())
        .forEach(rank -> this.hitHistory.put(rank, 0));
  }

  public int calculateIncome() {
    return Arrays.stream(Rank.values())
        .map(rank -> this.hitHistory.get(rank) * rank.getWinningReward())
        .reduce(0, Integer::sum);
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
