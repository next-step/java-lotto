package lotto.domain;

import java.util.Arrays;
import lotto.domain.money.Money;

public enum Prize {
  FIRST(6, Money.createWon(2_000_000_000), false),
  SECOND(5, Money.createWon(30_000_000), true),
  THIRD(5, Money.createWon(1_500_000), false),
  FOURTH(4, Money.createWon(50_000), false),
  FIFTH(3, Money.createWon(5_000), false),
  NOT_PRIZE(0, Money.createWon(0), false);

  private final int matchCount;
  private final Money prize;
  private final boolean matchBonus;

  Prize(int matchCount, Money prize, boolean matchBonus) {
    this.matchCount = matchCount;
    this.prize = prize;
    this.matchBonus = matchBonus;
  }

  public static Money getPrizeMoney(int count, boolean matchBonus) {
    return Arrays.stream(values())
        .filter(prize -> equalMatchCount(prize, count))
        .filter(prize -> matchBonus || !prize.matchBonus)
        .findAny()
        .map(prize -> prize.prize)
        .orElse(NOT_PRIZE.prize);
  }

  private static boolean equalMatchCount(Prize prize, int count) {
    return prize.matchCount == count;
  }

  public static Prize of(int count) {
    return Arrays.stream(values())
        .filter(prize -> equalMatchCount(prize, count))
        .findAny()
        .orElse(NOT_PRIZE);
  }

  public Money getPrize() {
    return prize;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public boolean winning() {
    return this != Prize.NOT_PRIZE;
  }
}
