package lotto.domain;

public enum WinMoney {

  THREE(3, 5_000),
  FOUR(4, 50_000),
  FIVE(5, 1_500_000),
  SIX(6, 2_000_000_000),
  ;

  private int matchCount;
  private long winMoney;

  WinMoney(int matchCount, long winMoney) {
    this.matchCount = matchCount;
    this.winMoney = winMoney;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public long getWinMoney() {
    return winMoney;
  }

  public boolean isWinLotto(Lotto lotto, WinNumbers winNumbers) {
    return lotto.matchCount(winNumbers) == matchCount;
  }

  public Money totalWinMoney(long winCount) {
    return new Money(this.winMoney * winCount);
  }
}
