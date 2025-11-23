package lotto.domain.game;

import lotto.domain.lotto.Money;

public enum Rank {

  FIRST(2_000_000_000, 6),
  SECOND(30_000_000, 5, true),
  THIRD(1_500_000, 5),
  FOURTH(50_000, 4),
  FIFTH(5000, 3),
  NONE(0, -1);

  private final int prize;
  private final int matched;
  private final boolean bonusMatched;

  Rank(int prize, int matched) {
    this(prize, matched, false);
  }

  Rank(int prize, int matched, boolean bonusMatched) {
    this.prize = prize;
    this.matched = matched;
    this.bonusMatched = bonusMatched;
  }

  public static Rank valueOf(int matched, boolean bonusMatched) {
    for (Rank rank : values()) {
      if (isMatch(rank, matched, bonusMatched)) {
        return rank;
      }
    }
    return NONE;
  }

  private static boolean isMatch(Rank rank, int matched,
      boolean bonusMatched) {
    if (rank.matched != matched) {
      return false;
    }
    if (matched != 5) {
      return true;
    }
    return rank.bonusMatched == bonusMatched;
  }

  public Money getPrize() {
    return new Money(this.prize);
  }

  @Override
  public String toString() {
    if (this == SECOND) {
      return this.matched + "개 일치, 보너스 볼 일치 (" + this.prize + "원)";
    }
    return this.matched + "개 일치 (" + this.prize + "원)";
  }
}