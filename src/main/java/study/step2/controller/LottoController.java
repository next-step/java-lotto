package study.step2.controller;

import study.step2.domain.Lotto;
import study.step2.domain.LottoNumber;
import study.step2.domain.LottoPrice;
import study.step2.domain.LottoResult;
import study.step2.domain.Lottos;
import study.step2.view.ResultView;

public class LottoController {

  public LottoController() {
  }

  public Lottos createLottos(int money) {
    LottoPrice lottoPrice  = new LottoPrice(money);
    int lottoCount = lottoPrice.lottoCount();

    Lottos lottos = Lotto.makeLottos(lottoCount);

    ResultView.printLottoCount(lottos.getLottos().size());

    ResultView.printLottos(lottos);

    return lottos;
  }

  public LottoResult findLottoWinning(Lottos lottos, Lotto winningLotto, int money, LottoNumber bonusNumber) {
    LottoResult lottoResult = lottos.match(winningLotto, bonusNumber);

    winningLotto.bonusValidation(bonusNumber);

    ResultView.printLottoResultMessage();

    ResultView.printLottoResult(lottoResult);

    ResultView.printYield(lottoResult, money);

    return lottoResult;
  }

}
