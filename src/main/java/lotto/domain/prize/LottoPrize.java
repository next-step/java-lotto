package lotto.domain.prize;

public enum LottoPrize {
  FIRST(200);

  private long prize;

  LottoPrize(long prize) {
    this.prize = prize;
  }

  public long getPrize() {
    return prize;
  }

}
