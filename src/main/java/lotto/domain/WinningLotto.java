package lotto.domain;
public class WinningLotto {
  private final Lotto resultLotto;
  private final LottoNumber bonusLottoNumber;

  public WinningLotto(Lotto resultLotto, LottoNumber bonusLottoNumber) {
    if (resultLotto.has(bonusLottoNumber)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달라야합니다.");
    }
    this.resultLotto = resultLotto;
    this.bonusLottoNumber = bonusLottoNumber;
  }

  public WinningLotto(String resultLotto, Integer bonusLottoNumber) {
    this(Lotto.defaultOf(resultLotto), LottoNumber.of(bonusLottoNumber));
  }

  public boolean hasBonusNumber(Lotto lotto) {
    return lotto.has(this.bonusLottoNumber);
  }

  public int matchNumberCount(Lotto lotto) {
    return lotto.matchNumberCount(resultLotto);
  }
}
