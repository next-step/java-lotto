package lotto.domain.place;

public class LottoFirstPlace extends LottoPlace {
  protected LottoFirstPlace(int count) {
    super(Rank.FIRST, count);
  }

  public static LottoPlace create() {
    return new LottoFirstPlace(0);
  }

  @Override
  public LottoPlace win() {
    return new LottoFirstPlace(plusCount());
  }
}
