package lotto.model;

public class WinningLotto {

  private final Lotto winningLotto;
  private final LottoNumber bonusLottoNumber;

  public WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
    this.winningLotto = winningLotto;
    this.bonusLottoNumber = bonusLottoNumber;
  }

  public static WinningLotto create(String winningLotto, int bonusLottoNumber) {
    return new WinningLotto(Lotto.create(winningLotto), LottoNumber.create(bonusLottoNumber));
  }

  public int matchWinningLottoNumbers(Lotto lotto) {
    return lotto.matchWinningLottoNumbers(winningLotto);
  }

  public Lotto getWinningLottoNumbers() {
    return winningLotto;
  }

  public boolean isWinningBonusLottoNumber(Lotto lotto) {
    return lotto.getLottoNumbers().contains(bonusLottoNumber);
  }
}
