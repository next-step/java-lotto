package lotto.domain;

import java.util.Arrays;

public enum Rank {

  NONE(new Match(Integer.MIN_VALUE, false), new Money(0)),
  THREE(new Match(3, false), new Money(5000)),
  FOUR(new Match(4, false), new Money(50_000)),
  FIVE(new Match(5, false), new Money(1_500_000)),
  FIVE_BONUS(new Match(5, true), new Money(30_000_000)),
  SIX(new Match(6, false), new Money(2_000_000_000));

  private final Match match;
  private final Money money;

  Rank(Match match, Money money) {
    this.match = match;
    this.money = money;
  }

  public static Rank from(final Match match) {
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.match.equals(match))
        .findAny()
        .orElse(Rank.NONE);
  }

  public int getMatchCount() {
    return match.getMatchCount();
  }

  public boolean isBonusNumberMatch() {
    return match.isBonusNumberMatch();
  }

  public Money getMoney() {
    return money;
  }
}
