package lotto.model;

public class WinningLotto {

  private final Lotto winningLotto;

  public WinningLotto(Lotto winningLotto) {
    this.winningLotto = winningLotto;
  }

  public static WinningLotto create(String winningLotto) {
    return new WinningLotto(Lotto.create(winningLotto));
  }

  public int matchWinningLottoNumbers(Lotto lotto) {
    return lotto.matchWinningLottoNumbers(winningLotto);
  }

  public Lotto getWinningLottoNumbers() {
    return winningLotto;
  }
}
