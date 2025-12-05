package lotto;

import java.util.Arrays;

public enum LottoRank {
  MISS(0, false, 0),
  FIFTH(3, false, 5_000),
  FOURTH(4, false, 50_000),
  THIRD(5, false, 1_500_000),
  SECOND(5, true, 30_000_000),
  FIRST(6, false, 2_000_000_000);

  private final int matchCount;
  private final boolean hasBonus;
  private final int prize;

  LottoRank(int matchCount, boolean hasBonus, int prize) {
    this.matchCount = matchCount;
    this.hasBonus = hasBonus;
    this.prize = prize;
  }

  public int matchCount() {
    return matchCount;
  }

  public int prize() {
    return prize;
  }

  public long prize(int count) {
    return (long) prize * count;
  }

  public static LottoRank of(int matchCount, boolean hasBonus) {
    return Arrays.stream(LottoRank.values())
        .filter(rank -> rank.matchCount == matchCount && rank.hasBonus == hasBonus)
        .findFirst()
        .orElse(MISS);
  }

}
