package lotto.domain.prize;

public enum LottoPrize {
  FIRST(6, 2_000_000_000L),
  SECOND(5, 1_500_000L),
  THIRD(4, 50_000L),
  FOURTH(3, 5_000L)
  ;

  private long countMatches;
  private long prize;

  LottoPrize(long countMatches, long prize) {
    this.countMatches = countMatches;
    this.prize = prize;
  }

  public long getPrize() {
    return prize;
  }

  public long getCountMatches() {
    return countMatches;
  }
}
