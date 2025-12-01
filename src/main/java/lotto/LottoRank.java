package lotto;

public enum LottoRank {
  MISS(0, 0),
  FIFTH(3, 5_000),
  FOURTH(4, 50_000),
  THIRD(5, 1_500_000),
  SECOND(5, 30_000_000),
  FIRST(6, 2_000_000_000);

  private final int matchCount;
  private final int prize;

  LottoRank(int matchCount, int prize) {
    this.matchCount = matchCount;
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
    if (matchCount == 6) {
      return FIRST;
    }
    if (matchCount == 5 && hasBonus) {
      return SECOND;
    }
    if (matchCount == 5) {
      return THIRD;
    }
    if (matchCount == 4) {
      return FOURTH;
    }
    if (matchCount == 3) {
      return FIFTH;
    }
    return MISS;
  }

}
