package lotto;

public enum LottoPrize {
  MATCH_3(3, 5_000),
  MATCH_4(4, 50_000),
  MATCH_5(5, 1_500_000),
  MATCH_6(6, 2_000_000_000),
  ;

  private final int matchCount;
  private final int prize;

  LottoPrize(int matchCount, int prize) {
    this.matchCount = matchCount;
    this.prize = prize;
  }

  public int getPrize() {
    return prize;
  }

  public static int getPrizeByMatchCount(int matchCount) {
    LottoPrize prize = findByMatchCount(matchCount);
    return prize != null ? prize.prize : 0;
  }

  public static LottoPrize findByMatchCount(int matchCount) {
    for (LottoPrize prize : LottoPrize.values()) {
      if (matchCount == prize.matchCount) {
        return prize;
      }
    }
    return null;
  }
}
