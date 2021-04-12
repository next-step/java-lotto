package lotto.domain.place;

public abstract class LottoPlace {
  protected final int count;

  protected LottoPlace(int count) {
    this.count = count;
  }

  public abstract LottoPlace win();
  public abstract int getCountOfMatch();
  public abstract long getWinningMoney();
  public abstract boolean matchedLottoNumberCount(int matched);
  public abstract boolean equals(Object o);
  public abstract int hashCode();

  public long getTotalMoney() {
    return getWinningMoney() * count;
  }

  public long getReturnOnInvestment() {
    return getTotalMoney() / getWinningMoney();
  }

  public String toString() {
    return "count : " + this.count + ", winMoney : " + getWinningMoney();
  }

  protected int plusCount() {
    return count + 1;
  }
}
