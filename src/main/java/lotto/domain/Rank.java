package lotto.domain;

import java.util.Arrays;

public enum Rank {

  NONE(Integer.MIN_VALUE, null, null),
  THREE(3, new Money(5000), "3개 일치 (5000원)"),
  FOUR(4, new Money(50_000), "4개 일치 (50000원)"),
  FIVE(5, new Money(1_500_000), "5개 일치 (1500000원)"),
  SIX(6, new Money(2_000_000_000), "6개 일치 (2000000000원)");

  private final int matchCount;
  private final Money money;
  private final String message;

  Rank(int matchCount, Money money, String message) {
    this.matchCount = matchCount;
    this.money = money;
    this.message = message;
  }

  public static Rank of(final int matchCount) {
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.matchCount == matchCount)
        .findAny()
        .orElse(Rank.NONE);
  }

  public Money getMoney() {
    return money;
  }

  public String getMessage() {
    return message;
  }
}
