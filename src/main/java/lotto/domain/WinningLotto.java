package lotto.domain;
public class WinningLotto {
  private final Lotto resultLotto;
  private final LottoNumber bonusLottoNumber;

  public WinningLotto(Lotto resultLotto, LottoNumber bonusLottoNumber) {
    this.resultLotto = resultLotto;
    this.bonusLottoNumber = bonusLottoNumber;
  }

  public WinningLotto(String resultLotto, Integer bonusLottoNumber) {
    this.resultLotto = Lotto.defaultOf(resultLotto);
    this.bonusLottoNumber = LottoNumber.of(bonusLottoNumber);
  }
}
