package lotto.domain;

import java.util.Arrays;

public enum Rank {

  NONE(new Match(Integer.MIN_VALUE, false), new Money(0), ""),
  THREE(new Match(3, false), new Money(5000), "3개 일치 (5000원)"),
  FOUR(new Match(4, false), new Money(50_000), "4개 일치 (50000원)"),
  FIVE(new Match(5, false), new Money(1_500_000), "5개 일치 (1500000원)"),
  FIVE_BONUS(new Match(5, true), new Money(30_000_000), "5개 일치, 보너스 볼 일치 (30000000원)"),
  SIX(new Match(6, false), new Money(2_000_000_000), "6개 일치 (2000000000원)");

  private final Match match;
  private final Money money;
  private final String message;

  Rank(Match match, Money money, String message) {
    this.match = match;
    this.money = money;
    this.message = message;
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

  public Money getMoney() {
    return money;
  }

  public String getMessage() {
    return message;
  }
}
