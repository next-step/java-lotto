package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum WinningLottery {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  NONE(0, 0);

  private final int matchedCount;
  private final long price;

  WinningLottery(int matchedCount, long price) {
    this.matchedCount = matchedCount;
    this.price = price;
  }

  public static WinningLottery of(int matchedCount, boolean matchedBonus) {
    Optional<WinningLottery> secondOrThird = secondOrThird(matchedCount, matchedBonus);

    return secondOrThird.orElseGet(() -> Arrays.stream(values())
        .filter(e -> e.matchedCount == matchedCount(matchedCount, matchedBonus))
        .findFirst()
        .orElse(NONE));
  }

  private static Optional<WinningLottery> secondOrThird(int matchedCount, boolean matchedBonus) {
    if (isSecond(matchedCount, matchedBonus)) {
      return Optional.of(WinningLottery.SECOND);
    }

    if (matchedCount == THIRD.matchedCount && !matchedBonus) {
      return Optional.of(WinningLottery.THIRD);
    }

    return Optional.empty();
  }

  private static boolean isSecond(int matchedCount, boolean matchedBonus) {
    return matchedCount == SECOND.matchedCount && matchedBonus;
  }

  public static List<WinningLottery> getValues() {
    return Arrays.stream(values())
        .sorted((o1, o2) -> {
          if (o1.matchedCount == o2.matchedCount) {
            return (int) (o1.price - o2.price);
          }
          return o1.matchedCount - o2.matchedCount;
        })
        .filter(e -> e != WinningLottery.NONE)
        .collect(Collectors.toList());
  }

  public static boolean matchedBonus(WinningLottery winningLottery) {
    return winningLottery.equals(WinningLottery.SECOND);
  }

  public int getMatchedCount() {
    return matchedCount;
  }

  public long getPrice() {
    return price;
  }

  private static int matchedCount(int matchedCount, boolean matchedBonus) {
    if (WinningLottery.isSecond(matchedCount, matchedBonus) || !matchedBonus) {
      return matchedCount;
    }

    return matchedCount - 1;
  }
}
