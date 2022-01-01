package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum WinningLottery {
  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000),
  NONE(-1, 0);

  private final int matchedCount;
  private final long price;

  WinningLottery(int matchedCount, long price) {
    this.matchedCount = matchedCount;
    this.price = price;
  }

  public static WinningLottery of(int matchedCount) {
    return Arrays.stream(values())
        .filter(e -> Objects.equals(e.matchedCount, matchedCount))
        .findFirst()
        .orElse(NONE);
  }
  
  public static List<WinningLottery> getValues() {
    return Arrays.stream(values())
        .sorted(Comparator.comparingInt(WinningLottery::matchedCount))
        .filter(e -> e != WinningLottery.NONE)
        .collect(Collectors.toList());
  }

  public int matchedCount() {
    return matchedCount;
  }

  public long price() {
    return price;
  }
}
