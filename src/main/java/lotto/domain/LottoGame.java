package lotto.domain;

public class LottoGame {

  private final Lottos lottos;
  private final Lotto resultLotto;
  private final LottoNumber bonusLottoNumber;

  private LottoGame(Lottos lottos, Lotto resultLotto, LottoNumber bonusLottoNumber) {
    if (resultLotto.has(bonusLottoNumber)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달라야합니다.");
    }
    this.lottos = lottos;
    this.resultLotto = resultLotto;
    this.bonusLottoNumber = bonusLottoNumber;
  }

  public static LottoGame defaultOf(Lottos lottos, String resultLottoNumbers,
      Integer bonusLottoNumberString) {
    return new LottoGame(lottos, Lotto.defaultOf(resultLottoNumbers),
        LottoNumber.of(bonusLottoNumberString));
  }

  public LottoResult resultWithBonusNumber() {
    return LottoMachine.matchWithBonusNumber(resultLotto, lottos, bonusLottoNumber);
  }
}
