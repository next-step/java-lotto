package lotto2.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Prize {
  NONE(0, 0),
  FOURTH(3, 5_000),
  THIRD(4, 50_000),
  SECOND(5, 1_500_000),
  FIRST(6, 2_000_000_000);

  private final int matchCount;
  private final int prizeMoney;

  Prize(int matchCount, int prizeMoney) {
    this.matchCount = matchCount;
    this.prizeMoney = prizeMoney;
  }

  public static Prize valueOf(int matchedCount) {
    for (Prize prize : Prize.values()) {
      if (prize.matchCount == matchedCount) {
        return prize;
      }
    }
    return NONE;
  }

  public static Map<Prize, Long> groupPrizesAndCount(List<Prize> prizes) {
    return prizes.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }


  public int matchCount() {
    return matchCount;
  }

  public int prizeMoney() {
    return prizeMoney;
  }
}
