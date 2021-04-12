package lotto.domain.place;

import java.util.Objects;

public class LottoFifthPlace extends LottoPlace {
  private final Rank value = Rank.FIFTH;

  protected LottoFifthPlace(int count) {
    super(count);
  }

  public static LottoPlace create() {
    return new LottoFifthPlace(0);
  }

  @Override
  public LottoPlace win() {
    return new LottoFifthPlace(plusCount());
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
  public boolean matchedLottoNumberCount(int matched) {
    return matched == getCountOfMatch();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoFifthPlace that = (LottoFifthPlace) o;
    return Objects.equals(count, that.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count);
  }
}
