package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rewards {

  private static final int INITIAL_COUNT_VALUE = 1;
  private static final int DEFAULT_COUNT_VALUE = 0;
  Map<Rank, Integer> reward = new HashMap<>();

  public Rewards(List<Rank> list) {
    list.stream().forEach(rank -> increaseCount(rank));
  }

  private void increaseCount(Rank rank) {
    if (reward.containsKey(rank)) {
      int count = reward.get(rank);
      reward.put(rank, ++count);
      return;
    }
    reward.put(rank, INITIAL_COUNT_VALUE);
  }

  public int getRankCount(Rank rank) {
    if (!reward.containsKey(rank)) {
      return DEFAULT_COUNT_VALUE;
    }
    return reward.get(rank);
  }

  public int totalIncome() {
    return Arrays.stream(Rank.values())
        .mapToInt(rank -> calculateReward(rank))
        .sum();
  }

  private int calculateReward(Rank rank) {
    int count = getRankCount(rank);
    return count * rank.getPrize();
  }

}
