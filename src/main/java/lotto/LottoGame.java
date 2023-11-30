package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class LottoGame {
  private final Lotto resultLotto;

  private LottoGame(Lotto resultLotto) {
    this.resultLotto = resultLotto;
  }

  public static LottoGame defaultOf(String resultLottoNumbers) {
    return new LottoGame(Lotto.defaultOf(resultLottoNumbers));
  }

  public LottoResult result(Lottos lottos){
    return LottoMachine.match(resultLotto, lottos);
  }
}
