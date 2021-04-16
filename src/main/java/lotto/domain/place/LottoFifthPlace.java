package lotto.domain.place;

public class LottoFifthPlace extends LottoPlace {
  protected LottoFifthPlace(int count) {
    super(Rank.FIFTH, count);
  }

  public static LottoPlace create() {
    return new LottoFifthPlace(0);
  }

  @Override
  public LottoPlace win() {
    return new LottoFifthPlace(plusCount());
  }
}
