package lotto.domain.place;

import java.util.Objects;

public class LottoFourthPlace extends LottoPlace {
  private final Rank value = Rank.FOURTH;

  protected LottoFourthPlace(int count) {
    super(count);
  }

  public static LottoPlace create() {
    return new LottoFourthPlace(0);
  }

  @Override
  public LottoPlace win() {
    return new LottoFourthPlace(plusCount());
  }

  @Override
  public boolean matchedLottoNumberCount(int matched) {
    return matched == getCountOfMatch();
  }

  @Override
  public int getCountOfMatch() {
    return value.getCountOfMatch();
  }

  @Override
  public long getWinningMoney() {
    return value.getWinningMoney();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoFourthPlace that = (LottoFourthPlace) o;
    return Objects.equals(count, that.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count);
  }
}
