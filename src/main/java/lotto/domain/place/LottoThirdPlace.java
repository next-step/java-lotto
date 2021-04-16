package lotto.domain.place;

public class LottoThirdPlace extends LottoPlace {
  protected LottoThirdPlace(int count) {
    super(Rank.THIRD, count);
  }

  public static LottoPlace create() {
    return new LottoThirdPlace(0);
  }

  @Override
  public LottoPlace win() {
    return new LottoThirdPlace(plusCount());
  }
}
