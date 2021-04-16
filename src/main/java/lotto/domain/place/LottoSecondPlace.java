package lotto.domain.place;

public class LottoSecondPlace extends LottoPlace {
  protected LottoSecondPlace(int count) {
    super(Rank.SECOND, count);
  }

  public static LottoPlace create() {
    return new LottoSecondPlace(0);
  }

  @Override
  public LottoPlace win() {
    return new LottoSecondPlace(plusCount());
  }
}
