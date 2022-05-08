package lotto.domain;

import java.util.Arrays;

public enum Prizes {
  FIRST(6, Money.of(2_000_000_000)),
  SECOND(5, Money.of(1_500_000)),
  THIRD(4, Money.of(50_000)),
  FOURTH(3, Money.of(5_000));

  private final int matchCount;
  private final Money prize;

  Prizes(int matchCount, Money prize) {
    this.matchCount = matchCount;
    this.prize = prize;
  }

  public static Money getPrizeMoney(int count) {
    return Arrays.stream(values())
        .filter(prizes -> prizes.matchCount == count)
        .findAny()
        .map(prizes -> prizes.prize)
        .orElse(Money.ZERO);
  }

  public static Prizes of(int count) {
    return Arrays.stream(values())
        .filter(prizes -> prizes.matchCount == count)
        .findAny()
        .orElse(null);
  }


  public Money getPrize() {
    return prize;
  }

  public int getMatchCount() {
    return matchCount;
  }
}
