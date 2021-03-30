package lotto.domain;

import java.util.Arrays;

public enum Rank {

  NONE(new LottoMatch(Integer.MIN_VALUE, false), new Money(0)),
  THREE(new LottoMatch(3, false), new Money(5000)),
  FOUR(new LottoMatch(4, false), new Money(50_000)),
  FIVE(new LottoMatch(5, false), new Money(1_500_000)),
  FIVE_BONUS(new LottoMatch(5, true), new Money(30_000_000)),
  SIX(new LottoMatch(6, false), new Money(2_000_000_000));

  private final LottoMatch lottoMatch;
  private final Money money;

  Rank(LottoMatch lottoMatch, Money money) {
    this.lottoMatch = lottoMatch;
    this.money = money;
  }

  public static Rank from(final LottoMatch lottoMatch) {
    return Arrays.stream(Rank.values())
        .filter(rank -> rank.lottoMatch.equals(lottoMatch))
        .findAny()
        .orElse(Rank.NONE);
  }

  public int getMatchCount() {
    return lottoMatch.getMatchCount();
  }

  public boolean isBonusNumberMatch() {
    return lottoMatch.isBonusNumberMatch();
  }

  public Money getMoney() {
    return money;
  }
}
