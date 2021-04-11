package lotto.domain.place;

public abstract class LottoPlace {
  protected final int count;

  protected LottoPlace(int count) {
    this.count = count;
  }

  public abstract LottoPlace win();
  public abstract int getMatched();
  public abstract long getWinMoney();
  public abstract boolean matchedLottoNumberCount(int matched);
  public abstract boolean equals(Object o);
  public abstract int hashCode();
  public abstract String toString();

  public long getTotalMoney() {
    return getWinMoney() * count;
  }

  public long getReturnOnInvestment() {
    return getTotalMoney() / getWinMoney();
  }

  protected int plusCount() {
    return count + 1;
  }
}
