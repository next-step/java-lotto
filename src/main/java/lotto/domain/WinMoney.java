package lotto.domain;

public enum WinMoney {

  THREE(3, false, 5_000),
  FOUR(4, false, 50_000),
  FIVE(5, false, 1_500_000),
  FIVE_ONE(5, true, 30_000_000),
  SIX(6, false, 2_000_000_000),
  ;

  private int matchCount;
  private boolean hasBonus;
  private long winMoney;

  WinMoney(int matchCount, boolean hasBonus, long winMoney) {
    this.matchCount = matchCount;
    this.hasBonus = hasBonus;
    this.winMoney = winMoney;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public long getWinMoney() {
    return winMoney;
  }

  public boolean isWinLotto(Lotto lotto, WinNumbers winNumbers) {

    long matchedCount = lotto.matchCount(winNumbers);
    if (matchCount == 5) {
      boolean isAdditionMatch = lotto.additionMatch(winNumbers);
      return matchedCount == matchCount && checkAdditionMatch(isAdditionMatch);
    }

    return matchedCount == matchCount;
  }

  private Boolean checkAdditionMatch(boolean isAdditionMatch) {

    if (this == WinMoney.FIVE_ONE) {
      return isAdditionMatch;
    }

    return !isAdditionMatch;
  }

  public Money totalWinMoney(long winCount) {
    return new Money(this.winMoney * winCount);
  }
}
