package lotto.domain.place;

import java.util.Objects;

public class LottoThirdPlace extends LottoPlace {
  private static final long WIN_MONEY = 50_000;
  private static final int MATCHED = 4;

  protected LottoThirdPlace(int count) {
    super(count);
  }

  public static LottoPlace create() {
    return new LottoThirdPlace(0);
  }

  @Override
  public LottoPlace win() {
    return new LottoThirdPlace(plusCount());
  }

  @Override
  public boolean matchedLottoNumberCount(int matched) {
    return matched == getMatched();
  }

  @Override
  public int getMatched() {
    return MATCHED;
  }

  @Override
  public long getWinMoney() {
    return WIN_MONEY;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoThirdPlace that = (LottoThirdPlace) o;
    return Objects.equals(count, that.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count);
  }

  @Override
  public String toString() {
    return "count : " + count + ", winMoney : " + WIN_MONEY;
  }
}
