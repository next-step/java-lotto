package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class LottoGame {
  private final Lotto resultLotto;
  private final LottoNumber bonusLottoNumber;

  private LottoGame(Lotto resultLotto, LottoNumber bonusLottoNumber) {
    resultLotto.has(bonusLottoNumber);
    this.resultLotto = resultLotto;
    this.bonusLottoNumber = bonusLottoNumber;
  }

  public static LottoGame defaultOf(String resultLottoNumbers, Integer bonusLottoNumberString) {
    return new LottoGame(Lotto.defaultOf(resultLottoNumbers), LottoNumber.of(bonusLottoNumberString));
  }

  public LottoResult result(Lottos lottos){
    return LottoMachine.match(resultLotto, lottos);
  }
}
