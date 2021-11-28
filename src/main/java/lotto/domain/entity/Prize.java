package lotto.domain.entity;

import java.util.Arrays;
import java.util.Map;

public enum Prize {

  MISS(0, 0),
  FIFTH(3, 5_000),
  FOURTH(4, 50_000),
  THIRD(5, 1_500_000),
  SECOND(5, 1_500_000),
  FIRST(6, 2_000_000_000);

  private static final int ZERO = 0;

  private final int matchedCount;
  private final int reward;

  Prize(int matchedCount, int reward) {
    this.matchedCount = matchedCount;
    this.reward = reward;
  }

  public int getMatchedCount() {
    return matchedCount;
  }

  public int getReward() {
    return reward;
  }

  public static Prize valueOf(int countOfMatch, boolean matchBonus) {
    return Arrays.stream(Prize.values())
                 .filter(prize -> prize != MISS && prize != SECOND)
                 .filter(prize -> prize.getMatchedCount() == countOfMatch)
                 .map(prize -> {
                   if (prize == THIRD && matchBonus) {
                     return SECOND;
                   }
                   return prize;
                 })
                 .findAny()
                 .orElse(MISS);
  }

  public static void inputValuesToMap(Map<Prize, Integer> map) {
    Arrays.stream(Prize.values())
          .filter(prize -> prize != MISS)
          .forEach(prize -> map.put(prize, ZERO));
  }

}
