package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum WinningLottery {
  FIRST(6, 2000000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FOURTH(3, 5000),
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
        .sorted(Comparator.comparingInt(WinningLottery::getMatchedCount))
        .filter(e -> e != WinningLottery.NONE)
        .collect(Collectors.toList());
  }

  public int getMatchedCount() {
    return matchedCount;
  }

  public long getPrice() {
    return price;
  }
}
