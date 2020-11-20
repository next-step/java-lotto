package lotto;

import static lotto.LottoGameConstant.MAXIMUM_REWARD_HIT;
import static lotto.LottoGameConstant.MINIMUM_HIT;
import static lotto.LottoGameConstant.MINIMUM_REWARD_HIT;

import java.util.HashMap;
import java.util.Map;

//TODO: Enum 활용 공부. 최우선 수정
public class LottoResult {

  private final int HIT_THREE = 5_000;
  private final int HIT_FOUR = 50_000;
  private final int HIT_FIVE = 15_000_000;
  private final int HIT_SIX = 2_000_000_000;

  private final Map<Integer, Integer> rewards;
  private final Map<Integer, Integer> hitRecorder;

  public LottoResult() {
    this.rewards = new HashMap<>();
    this.hitRecorder = new HashMap<>();

    for (int hit = MINIMUM_HIT; hit <= MAXIMUM_REWARD_HIT; hit++) {
      this.hitRecorder.put(hit, 0);
      this.rewards.put(hit, 0);
    }
    this.rewards.put(3, HIT_THREE);
    this.rewards.put(4, HIT_FOUR);
    this.rewards.put(5, HIT_FIVE);
    this.rewards.put(6, HIT_SIX);
  }

  public int calculateIncome() {
    int result = 0;
    for (int hit = MINIMUM_REWARD_HIT; hit <= MAXIMUM_REWARD_HIT; hit++) {
      result += (hitRecorder.get(hit) * rewards.get(hit));
    }
    return result;
  }

  public void recordHit(int numHit) {
    this.hitRecorder.put(numHit, this.hitRecorder.get(numHit) + 1);
  }

  public int getReward(int numHit) {
    return this.rewards.get(numHit);
  }

  public int getRecordedNumberOfHit(int numHit) {
    return this.hitRecorder.get(numHit);
  }
}
