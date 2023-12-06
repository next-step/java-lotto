package lotto.domain;

public class LottoGame {

  private final Lottos lottos;
  private final Lotto resultLotto;
  private final LottoNumber bonusLottoNumber;
  private final WinningLotto winningLotto;

  private LottoGame(Lottos lottos, Lotto resultLotto, LottoNumber bonusLottoNumber) {
    if (resultLotto.has(bonusLottoNumber)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달라야합니다.");
    }
    this.lottos = lottos;
    this.resultLotto = resultLotto;
    this.bonusLottoNumber = bonusLottoNumber;
    this.winningLotto = null;
  }

  private LottoGame(Lottos lottos, WinningLotto winningLotto) {
    this.lottos = lottos;
    this.resultLotto = null;
    this.bonusLottoNumber = null;
    this.winningLotto = winningLotto;
  }

  public static LottoGame defaultOf(Lottos lottos, String resultLottoNumbers,
      Integer bonusLottoNumberString) {
    return new LottoGame(lottos, Lotto.defaultOf(resultLottoNumbers),
        LottoNumber.of(bonusLottoNumberString));
  }

  public static LottoGame defaultOf(Lottos lottos, WinningLotto winningLotto) {
    return new LottoGame(lottos, winningLotto);
  }

  public LottoResult resultWithBonusNumber() {
    return lottos.resultWithBonusNumber(winningLotto);
  }

}
