package lotto.domain.place;

import java.util.Objects;

public class LottoSecondPlace extends LottoPlace {
  private static final int WIN_MONEY = 1_500_000;
  private static final int MATCHED = 5;

  protected LottoSecondPlace(int count) {
    super(count);
  }

  public static LottoPlace create() {
    return new LottoSecondPlace(0);
  }

  @Override
  public LottoPlace win() {
    return new LottoSecondPlace(plusCount());
  }

  @Override
  public boolean matchedLottoNumberCount(int matched) {
    return matched == MATCHED;
  }

  @Override
  protected int getWinMoney() {
    return WIN_MONEY;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoSecondPlace that = (LottoSecondPlace) o;
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
