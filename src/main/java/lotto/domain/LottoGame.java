package lotto.domain;

public class LottoGame {

  private final Lottos lottos;
  private final WinningLotto winningLotto;


  private LottoGame(Lottos lottos, WinningLotto winningLotto) {
    this.lottos = lottos;
    this.winningLotto = winningLotto;
  }

  public static LottoGame defaultOf(Lottos lottos, WinningLotto winningLotto) {
    return new LottoGame(lottos, winningLotto);
  }

  public LottoResult resultWithBonusNumber() {
    return lottos.resultWithBonusNumber(winningLotto);
  }

}
