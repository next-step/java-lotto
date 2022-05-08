package lotto.domain;

import java.util.Arrays;

public enum Prizes {
  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000);

  private final int matchCount;
  private final long prize;

  Prizes(int matchCount, long prize) {
    this.matchCount = matchCount;
    this.prize = prize;
  }

  public static long of(int count) {
    return Arrays.stream(values())
        .filter(prizes -> prizes.matchCount == count)
        .findAny()
        .map(prizes -> prizes.prize)
        .orElse(0L);
  }
}
