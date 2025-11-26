package lotto;

public enum LottoRank {
  THREE(3, 5_000),
  FOUR(4, 50_000),
  FIVE(5, 1_500_000),
  SIX(6, 2_000_000_000);

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

  public static LottoRank of(int matchCount) {
    for (LottoRank rank : values()) {
      if (rank.matchCount == matchCount) {
        return rank;
      }
    }
    return null;
  }

}
