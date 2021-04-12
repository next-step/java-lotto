package lotto.domain.place;

import java.util.Objects;

public abstract class LottoPlace {
  protected final Rank value;
  protected final int count;

  protected LottoPlace(Rank value, int count) {
    this.value = value;
    this.count = count;
  }

  public abstract LottoPlace win();

  public long getTotalWinningMoney() {
    return getWinningMoney() * count;
  }

  public long getPercentOfInvestment() {
    return getTotalWinningMoney() / getWinningMoney();
  }

  public boolean isMatch(int countOfMatch) {
    return countOfMatch == getCountOfMatch();
  }

  public int getCountOfMatch() {
    return value.getCountOfMatch();
  }

  public long getWinningMoney() {
    return value.getWinningMoney();
  }

  protected int plusCount() {
    return count + 1;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoPlace that = (LottoPlace) o;
    return Objects.equals(count, that.count)
            && Objects.equals(value, that.value);
  }

  public int hashCode() {
    return Objects.hash(count, value);
  }

  public String toString() {
    return "count : " + this.count + ", winningMoney : " + getWinningMoney();
  }
}
