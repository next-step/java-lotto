package lotto;

import static lotto.LottoGameConstant.MAXIMUM_REWARD_HIT;
import static lotto.LottoGameConstant.MINIMUM_HIT;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

  private final Map<Integer, Integer> hitHistory;

  public LottoResult() {
    this.hitHistory = new HashMap<>();

    for (int hit = MINIMUM_HIT; hit <= MAXIMUM_REWARD_HIT; hit++) {
      this.hitHistory.put(hit, 0);
    }
  }

  public int calculateIncome() {
    return Rank.calculateTotalReward(hitHistory);
  }

  public void recordHit(int numHit) {
    this.hitHistory.put(numHit, this.hitHistory.get(numHit) + 1);
  }

  public int getReward(int numHit) {
    return Rank.getRewardFromNumHit(numHit);
  }

  public int getRecordedNumberOfHit(int numHit) {
    return this.hitHistory.get(numHit);
  }
}
