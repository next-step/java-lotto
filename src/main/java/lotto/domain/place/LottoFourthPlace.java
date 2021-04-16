package lotto.domain.place;

public class LottoFourthPlace extends LottoPlace {
  protected LottoFourthPlace(int count) {
    super(Rank.FOURTH, count);
  }

  public static LottoPlace create() {
    return new LottoFourthPlace(0);
  }

  @Override
  public LottoPlace win() {
    return new LottoFourthPlace(plusCount());
  }
}
